package com.sunshine.spring.boot.laboratory.mq.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kafka客户端配置
 * @author sunshine
 * @created 2020-03-01
 */
@Configuration
public class KafkaConfiguration {

	// Kafka配置开始

	/**
	 * @return 创建topic Bean
	 */
	@Bean
	public NewTopic buildSunshineTopic() {
		return new NewTopic("sunshine", 1, (short) 1);
	}

	// Kafka配置结束

	// producer配置开始
	@Bean
	public ProducerFactory<String, String> buildProducerFactory() {
		Map<String, Object> kafkaProducerConfigMap = new HashMap<>();
		kafkaProducerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");
		kafkaProducerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");
		kafkaProducerConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, List.of("127.0.0.1:9092"));
		// kafkaProducerConfigMap.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
		DefaultKafkaProducerFactory defaultKafkaProducerFactory = new DefaultKafkaProducerFactory(kafkaProducerConfigMap);
		// defaultKafkaProducerFactory.setProducerPerConsumerPartition(true);
		// defaultKafkaProducerFactory.setProducerPerThread(true);
		return defaultKafkaProducerFactory;
	}

	@Bean
	public KafkaTemplate buildKafkaTemplate() {
		KafkaTemplate kafkaTemplate = new KafkaTemplate(buildProducerFactory(), true);
		// kafkaTemplate.setProducerListener(new SunshineProducerListener());
		return kafkaTemplate;
	}
	// producer配置结束

	// consumer配置开始
	@Bean
	public ConsumerFactory<String, String> buildConsumerFactory() {
		Map<String, Object> kafkaConsumerConfigMap = new HashMap<>();

		DefaultKafkaConsumerFactory defaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory(kafkaConsumerConfigMap);
		return defaultKafkaConsumerFactory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<?, ?> buildKafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer concurrentKafkaListenerContainerFactoryConfigurer, ConsumerFactory<String, String> consumerFactory, KafkaTemplate<Object, Object> kafkaTemplate) {
		ConcurrentKafkaListenerContainerFactory<?, ?> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate), new FixedBackOff(0L, 2)));
		return concurrentKafkaListenerContainerFactory;
	}
	// consumer配置结束
}

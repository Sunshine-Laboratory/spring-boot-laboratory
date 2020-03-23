package com.sunshine.spring.boot.laboratory.mq.kafka.service.impl;

import com.sunshine.spring.boot.laboratory.mq.kafka.service.KafkaProduceService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author sunshine
 * @created 2020-03-23
 */
@Service("kafkaSynchronousProduceService")
public class KafkaSynchronousProduceServiceImpl implements KafkaProduceService {

	private final KafkaTemplate kafkaTemplate;

	@Autowired
	public KafkaSynchronousProduceServiceImpl(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public String produce(String message) throws Exception {
		Future<SendResult<String, String>> future = kafkaTemplate.send("sunshine", message);
		SendResult<String, String> sendResult = future.get();
		ProducerRecord<String, String> producerRecord = sendResult.getProducerRecord();
		RecordMetadata recordMetadata = sendResult.getRecordMetadata();
		return String.format("SendResult，发送消息：%s，消息元数据：%s", producerRecord.toString(), recordMetadata.toString());
	}
}

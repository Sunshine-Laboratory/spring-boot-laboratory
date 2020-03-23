package com.sunshine.spring.boot.laboratory.mq.kafka.controller;

import com.sunshine.spring.boot.laboratory.mq.kafka.service.KafkaProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka消息发送控制器
 * @author sunshine
 * @created 2020-03-01
 */
@RestController
@RequestMapping("/laboratory/kafka")
public class KafkaController {

	/**
	 * Kafka生产服务
	 */
	private final KafkaProduceService kafkaProduceService;
	/**
	 * Kafka同步生产服务
	 */
	private final KafkaProduceService kafkaSynchronousProduceService;

	@Autowired
	public KafkaController(@Qualifier("kafkaProduceService") KafkaProduceService kafkaProduceService, @Qualifier("kafkaSynchronousProduceService") KafkaProduceService kafkaSynchronousProduceService) {
		this.kafkaProduceService = kafkaProduceService;
		this.kafkaSynchronousProduceService = kafkaSynchronousProduceService;
	}

	@PostMapping("/produce/{message}")
	public String produce(@PathVariable String message) throws Exception {
		return kafkaProduceService.produce(message);
	}

	@PostMapping("/synchronous/produce/{message}")
	public String synchronousProduce(@PathVariable String message) throws Exception {
		return kafkaSynchronousProduceService.produce(message);
	}
}

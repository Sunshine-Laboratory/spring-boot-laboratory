package com.sunshine.spring.boot.laboratory.mq.kafka.service.impl;

import com.sunshine.spring.boot.laboratory.mq.kafka.service.KafkaProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.TransactionSupport;
import org.springframework.stereotype.Service;

/**
 * Kafka生产服务实现
 * @author sunshine
 * @created 2020-03-01
 */
@Service("kafkaProduceService")
public class KafkaProduceServiceImpl implements KafkaProduceService {

	private final KafkaTemplate<Object, Object> kafkaTemplate;

	@Autowired
	public KafkaProduceServiceImpl(KafkaTemplate<Object, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public String produce(String message) {
		TransactionSupport.setTransactionIdSuffix("1");
		this.kafkaTemplate.send("sunshine", 8, "", message);
		return "success";
	}
}

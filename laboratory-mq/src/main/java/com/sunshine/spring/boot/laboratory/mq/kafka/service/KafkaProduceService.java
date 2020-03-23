package com.sunshine.spring.boot.laboratory.mq.kafka.service;

/**
 * Kafka生产服务
 * @author sunshine
 * @created 2020-03-01
 */
public interface KafkaProduceService {

	/**
	 * 生产消息
	 * @param message 消息对象
	 * @return 生产结果
	 */
	String produce(String message) throws Exception;
}

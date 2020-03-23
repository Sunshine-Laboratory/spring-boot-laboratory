package com.sunshine.spring.boot.laboratory.mq.kafka.listener;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * @author sunshine
 * @created 2020-03-23
 */
public class SunshineProducerListener implements ProducerListener {

	@Override
	public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
		System.out.println(String.format("SunshineProducerListener，发送消息：%s，消息元数据：%s", producerRecord.toString(), recordMetadata.toString()));
	}

	@Override
	public void onError(ProducerRecord producerRecord, Exception exception) {
		System.out.println(String.format("SunshineProducerListener，发送消息：%s，异常为：%s", producerRecord.toString(), exception.toString()));
	}
}

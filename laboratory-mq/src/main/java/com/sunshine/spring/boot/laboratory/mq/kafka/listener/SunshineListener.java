package com.sunshine.spring.boot.laboratory.mq.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author sunshine
 * @created 2020-03-15
 */
@Component("sunshineListener")
public class SunshineListener {

	@KafkaListener(id = "sunshineListener", topics = {"sunshine"})
	public void sunshineListener(String message) {
		System.out.println(message);
	}
}

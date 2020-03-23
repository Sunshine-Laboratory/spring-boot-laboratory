package com.sunshine.spring.boot.laboratory.mq.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka启动器
 * @author sunshine
 * @created 2020-03-01
 */
@SpringBootApplication
public class KafkaBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBootstrap.class, args);
	}
}

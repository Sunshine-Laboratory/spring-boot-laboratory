package com.sunshine.spring.boot.laboratory.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * AOP实验室启动器
 * @author sunshine
 * @created 2019-11-28
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AOPBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(AOPBootstrap.class, args);
	}
}

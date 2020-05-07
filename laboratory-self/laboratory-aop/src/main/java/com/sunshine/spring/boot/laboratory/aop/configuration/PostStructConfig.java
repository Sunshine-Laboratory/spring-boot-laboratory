package com.sunshine.spring.boot.laboratory.aop.configuration;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author sunshine
 * @created 2020-04-21
 */
@Component
public class PostStructConfig {

	@PostConstruct
	public void init() {
		System.out.println(1);
	}
}

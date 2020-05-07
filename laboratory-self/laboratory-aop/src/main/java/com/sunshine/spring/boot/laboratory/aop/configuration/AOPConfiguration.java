package com.sunshine.spring.boot.laboratory.aop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AOP配置类
 * @author <sunshine>
 * @created 2020/5/7
 */
@Configuration
public class AOPConfiguration {

	@Bean
	public String aopBean() {
		return "AOP bean";
	}
}

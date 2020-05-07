package com.sunshine.spring.boot.laboratory.aop.service;

/**
 * AOP实验通用服务
 * @author sunshine
 * @created 2020-04-03
 */
public interface AOPExperimentService {
	/**
	 * 获取实验信息
	 * @param id 实验ID
	 * @return 实验信息
	 */
	String queryExperimentById(int id);
}

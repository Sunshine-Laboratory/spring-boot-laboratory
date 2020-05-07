package com.sunshine.spring.boot.laboratory.aop.service.impl;

import com.sunshine.spring.boot.laboratory.aop.service.AOPExperimentService;
import org.springframework.stereotype.Service;

/**
 * AOP实验通用服务实现
 * @author sunshine
 * @created 2020-04-03
 */
@Service("aopExperimentService")
public class AOPExperimentServiceImpl implements AOPExperimentService {

	@Override
	public String queryExperimentById(int id) {
		return "正在进行AOP实验";
	}
}

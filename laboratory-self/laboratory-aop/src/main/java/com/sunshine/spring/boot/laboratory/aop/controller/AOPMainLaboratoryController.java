package com.sunshine.spring.boot.laboratory.aop.controller;

import com.sunshine.spring.boot.laboratory.aop.service.AOPExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunshine
 * @created 2020-04-03
 */
@RestController
@Scope("prototype")
@RequestMapping("/laboratory/aop")
public class AOPMainLaboratoryController {

	private final AOPExperimentService aopExperimentService;

	@Autowired
	public AOPMainLaboratoryController(AOPExperimentService aopExperimentService) {
		this.aopExperimentService = aopExperimentService;
	}

	@GetMapping("/experiment/{id}")
	@Scope("prototype")
	public String queryExperimentByExperimentId(@PathVariable Integer id) {
		Assert.notNull(id, "实验ID不能为null");
		Assert.isTrue(id > 0, "实验ID必须大于0");
		return aopExperimentService.queryExperimentById(id);
	}
}

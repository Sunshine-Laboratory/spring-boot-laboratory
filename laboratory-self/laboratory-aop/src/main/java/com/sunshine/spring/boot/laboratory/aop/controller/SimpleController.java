package com.sunshine.spring.boot.laboratory.aop.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <sunshine>
 * @created 2020/5/7
 */
@RestController
@RequestMapping("/laboratory/aop/simple")
public class SimpleController {

	@GetMapping("/experiment")
	public String querySimpleExperimentById(@RequestParam Integer id) {
		Assert.notNull(id, "简单实验ID不能为空");
		return "简单实验";
	}

	@GetMapping("/experiment/protected")
	String queryProtectedSimpleExperimentById(Integer id) {
		Assert.notNull(id, "保护性简单实验ID不能为空");
		return "保护性简单实验";
	}

	@GetMapping("/experiment/private")
	private String queryPrivateSimpleExperimentById(Integer id) {
		Assert.notNull(id, "私有性简单实验ID不能为空");
		return "私有性简单实验";
	}
}

package com.sunshine.spring.boot.laboratory.aop.aspect;

import com.sunshine.spring.boot.laboratory.aop.utils.ExperimentUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Sunshine第一个Aspect切面
 * @author sunshine
 * @created 2019/11/28
 */
@Aspect
@Component
public class SunshineFirstAspect {

	@Pointcut("execution(String com.sunshine.spring.boot.laboratory.aop.controller.AOPMainLaboratoryController.queryExperimentByExperimentId(..))")
	public void pointcut() {

	}

	@Around("pointcut()")
	public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
		if (!ExperimentUtils.isUserValid()) {
			return "用户无法访问实验内容";
		}
		return joinPoint.proceed();
	}
}

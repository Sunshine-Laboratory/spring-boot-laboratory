package com.sunshine.spring.boot.laboratory.aop.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sunshine
 * @created 2020-04-03
 */
public class ExperimentUtils {

	/**
	 * 实验请求用户是否合法
	 * @return 请求用户是否合法
	 */
	public static boolean isUserValid() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int current = random.nextInt(20);
		if (current < 10) {
			return true;
		}
		return false;
	}
}

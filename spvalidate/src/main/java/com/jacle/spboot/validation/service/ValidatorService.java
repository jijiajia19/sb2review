package com.jacle.spboot.validation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//一般所有的校验都是在controller层处理好，在调用service，但是spring也支持service层调用validate
@Validated
@Service
public class ValidatorService {

	private static final Logger logger = LoggerFactory.getLogger(ValidatorService.class);

	public String show(@NotNull(message = "不能为空") @Min(value = 18, message = "最小18") String age) {
		logger.info("age = {}", age);
		return age;
	}

}
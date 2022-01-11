package com.jacle.spboot.validation.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author Jacle
 * @version 1.0
 * @description: Springboot配置相关
 *         1、普通校验
 *         2、快速校验
 *     设置校验模式
 * @date 2022/1/10 16:45
 */
@Configuration
@Slf4j
public class Config
{
    @Bean
    public Validator validator()
    {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        log.info("加载参数校验设置...");
        return validator;
    }
}

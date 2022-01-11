package com.jacle.spboot.validation.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Jacle
 * @version 1.0
 * @description: Conditional等条件注解的使用
 * @date 2022/1/11 14:56
 */
//@ConditionalOnProperty(value="cond_var",havingValue = "dev",matchIfMissing = false)
//条件加载
//@ConditionalOnExpression("'${cond_var}'!='dev'")
//@SelfConditionalAnnotation
@ConditionalOnCustomAnd
@Component
@Slf4j
public class ConditionalCase
{
    @Value("${cond_var:none}")
    private String env;

    @PostConstruct
    public void prt()
    {
        log.info("条件环境中使用变量{}", this.env);
    }
}

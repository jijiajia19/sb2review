package com.jacle.spboot.validation.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.lang.annotation.*;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义注解，方便重用
 * @date 2022/1/11 16:47
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnExpression("'${cond_var}'!='dev'")
public @interface SelfConditionalAnnotation
{


}

package com.jacle.spboot.validation.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnCustomAndCondition.class)
public @interface ConditionalOnCustomAnd
{

}
package com.jacle.spboot.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义注解校验器
 * @date 2022/1/11 12:06
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)  //注解在运行时起作用
@Documented
@Constraint(validatedBy = CheckAgeImpl.class)
public @interface CheckAgeValidator
{
    //message，groups，payload三个属性是必须的，如果没有使用，也不能省略
    String message() default "自定义消息...";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

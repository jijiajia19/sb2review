package com.jacle.spboot.validation.domain;

import com.jacle.spboot.validation.validator.CheckAgeValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义注解验证
 * @date 2022/1/11 10:02
 */
//能够验证但是无法得到具体的错误提示
//验证复杂的需求
@Data
@Slf4j
@CheckAgeValidator
public class Unit
{
    @NotBlank
    private String name;

    @NotNull(message = "age不能为null")
    private int age;

}

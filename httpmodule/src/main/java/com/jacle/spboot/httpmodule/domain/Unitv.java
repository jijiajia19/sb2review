package com.jacle.spboot.httpmodule.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * @author Jacle
 * @version 1.0
 * @description: 参数是集合的验证案例
 * @date 2022/1/14 14:00
 */
@Slf4j
@Data
public class Unitv
{
    @Max(value = 19)
    private int age;

    @NotBlank
    private String name;
}

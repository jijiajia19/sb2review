package com.jacle.spboot.validation.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Dog
{
    @NotBlank
    private String name;

    @NotBlank(message="type不能为空")
    private String type;

    @Min(0)
    private int age;
}
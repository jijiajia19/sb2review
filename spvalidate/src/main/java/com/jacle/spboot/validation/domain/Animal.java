package com.jacle.spboot.validation.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class Animal
{
    @Min(1)
    private int count;

    //属性是集合还是可以校验内部类对象属性的
    @Valid
    @NotNull
    @Size(min = 1)
    //dogs的验证一定要包两层，直接防止Dos无效果
    private List<Dog> dogs = new ArrayList<Dog>();

}
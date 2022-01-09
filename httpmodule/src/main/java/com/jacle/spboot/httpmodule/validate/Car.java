package com.jacle.spboot.httpmodule.validate;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Car
{

    @NotNull
    private String type;

    @NotNull
    //级联校验采用Valid注解来处理
    @Valid
    private PersonInfo driver;
}

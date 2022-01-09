package com.jacle.spboot.httpmodule.validate;

import lombok.Data;

//spring3之前我们是通过validator来实现，每个类都写一个验证器
//2.3之后需要自己一引入validator
@Data
public class Person
{

    private String name;
    private int age;
}
package com.jacle.spboot.httpmodule.missingannotation;

public class Dog implements Animal {
    @Override
    public String eat() {
        return "肉";
    }
}

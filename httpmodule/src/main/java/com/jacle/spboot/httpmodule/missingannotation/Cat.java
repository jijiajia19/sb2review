package com.jacle.spboot.httpmodule.missingannotation;

public class Cat implements Animal {
    @Override
    public String eat() {
        return "老鼠";
    }
}
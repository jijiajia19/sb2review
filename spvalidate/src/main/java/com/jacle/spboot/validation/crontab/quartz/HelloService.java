package com.jacle.spboot.validation.crontab.quartz;

import java.util.Date;

public class HelloService
{
    public String sayHello()
    {
        System.out.println("hello service >>>" + new Date());

        return "hello service";
    }
}
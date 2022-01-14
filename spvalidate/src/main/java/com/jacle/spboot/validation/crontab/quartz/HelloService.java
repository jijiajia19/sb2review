package com.jacle.spboot.validation.crontab.quartz;

import java.io.Serializable;
import java.util.Date;

public class HelloService implements Serializable
{
    public String sayHello()
    {
        System.out.println("hello service >>>" + new Date());

        return "hello service";
    }
}
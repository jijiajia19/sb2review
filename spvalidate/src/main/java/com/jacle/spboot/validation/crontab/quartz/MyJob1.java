package com.jacle.spboot.validation.crontab.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 无参数简单任务
 * @date 2022/1/13 13:15
 */
@Component
public class MyJob1
{
    public void sayHello()
    {
        System.out.println("MyJob1>>>" + new Date());
    }
}

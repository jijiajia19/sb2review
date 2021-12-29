package com.jacle.spboot.annocationssm.servlet;

import com.jacle.spboot.annocationssm.java8.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试Configuration注解测试
 * @date 2021/12/29 13:24
 */
public class TestMainConfig
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(ctx.getBean("person"));
        System.out.println(ctx.getBean("car"));
        System.out.println(ctx.getBean("car"));
    }
}

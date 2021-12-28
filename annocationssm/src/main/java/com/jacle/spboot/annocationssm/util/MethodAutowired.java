package com.jacle.spboot.annocationssm.util;

import com.jacle.spboot.annocationssm.domain.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jacle
 * @version 1.0
 * @description: autowired在方法上进行注入，等价 成员变量装配,可以将方法看做成员变量
 * @date 2021/12/28 14:35
 */
@Component
public class MethodAutowired
{
    //在方法上的autowired会自动执行方法，set方法是对成员变量注入，有实体的参数会进行注入
    //可以当做初始化执行方法
    @Autowired
    public void test()
    {
        System.out.println("test...");
    }

    @Autowired
    public void test2(TUser t)
    {
        System.out.println("test2..."+t.toString());
    }
}

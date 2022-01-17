package com.jacle.spboot.httpmodule.exception.as;

import org.springframework.util.Assert;

/**
 * @author Jacle
 * @version 1.0
 * @description: Spring的断言使用
 * @date 2022/1/14 17:46
 */
public class AssertDemo
{
    //可以通过这种封装方式，自己封装，提高代码的可读性
    public static void main(String[] args)
    {
        //IllegalArgumentException
        //主要用来做参数校验，非法校验
        Assert.isTrue(1<0,"测试spring的断言");
    }
}

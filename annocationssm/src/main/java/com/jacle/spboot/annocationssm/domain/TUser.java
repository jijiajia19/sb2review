package com.jacle.spboot.annocationssm.domain;

import org.springframework.stereotype.Component;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试内容协商机制
 * @date 2021/12/24 15:41
 */

@Component
public class TUser
{
    private String name;
    private int age;

    public TUser()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

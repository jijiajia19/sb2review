package com.jacle.spboot.validation.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacle.spboot.validation.domain.Animal;
import com.jacle.spboot.validation.domain.Dog;
import com.jacle.spboot.validation.domain.ValidateList;

import java.util.Arrays;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试自定义集合参数类
 * @date 2022/1/10 17:21
 */
public class Test
{
    @org.junit.Test
    public void test() throws JsonProcessingException
    {
        Animal a = new Animal();
        Dog d = new Dog();
        d.setAge(2);
        d.setName("jacle");
        d.setType("2");
        a.setCount(1);
        a.setDogs(Arrays.asList(new Dog[]{d}));

        ValidateList vlist=new ValidateList();
        vlist.list.add(a);

        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(jsonMapper.writeValueAsString(vlist));

    }
}

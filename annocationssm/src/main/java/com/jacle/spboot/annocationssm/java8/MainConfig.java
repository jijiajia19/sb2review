package com.jacle.spboot.annocationssm.java8;

import com.jacle.spboot.annocationssm.domain.Car;
import com.jacle.spboot.annocationssm.domain.Person;
import org.springframework.context.annotation.Bean;

public class MainConfig
{
    //如果作为参数进行Bean的注解映射，没有任何问题
    //如果单纯调用方法，需要加上@configuration
    @Bean
    public Person person(Car c)
    {
        return new Person(c);
    }

    @Bean
    public Car car()
    {
        return new Car();
    }
}

package com.jacle.spboot.validation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jacle
 * @version 1.0
 * @description: 启动类
 * @date 2022/1/10 9:09
 */
@MapperScan("com.jacle.spboot.validation.crontab")
@SpringBootApplication
@EnableScheduling
public class RunApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RunApplication.class);
    }
}

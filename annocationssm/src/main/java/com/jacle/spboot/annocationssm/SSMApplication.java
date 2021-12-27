package com.jacle.spboot.annocationssm;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 以XML方式整合SSM.
 * MapperScan:扫描Mybatis接口文件
 */
@Slf4j
@MapperScan("com.jacle.spboot.annocationssm.domain")
//启动类本身就是一个@configuration的注解
@SpringBootApplication
public class SSMApplication
{

    public static void main(String[] args)
    {
        log.info("程序开始启动:" + "start...");
        SpringApplication.run(SSMApplication.class, args);
    }



}

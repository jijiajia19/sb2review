package com.jacle.spboot.xmlssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 以XML方式整合SSM.
 * MapperScan:扫描Mybatis接口文件
 */
@MapperScan("com.jacle.spboot.xmlssm.domain.mapper")
@SpringBootApplication
public class SSMApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SSMApplication.class, args);
    }

}

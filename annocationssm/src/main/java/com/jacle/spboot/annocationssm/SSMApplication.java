package com.jacle.spboot.annocationssm;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 以XML方式整合SSM.
 * MapperScan:扫描Mybatis接口文件
 */
@Slf4j
//如果使用的注解，MapperScan还是需要添加的，虽然有事会warnning，可以忽略

@MapperScan("com.jacle.spboot.annocationssm.domain")
//启动类本身就是一个@configuration的注解
@SpringBootApplication
//        (exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan(basePackages = {"com.jacle.spboot.annocationssm.servlet"})
public class SSMApplication
{
    public static void main(String[] args)
    {
        log.info("程序开始启动:" + "start...");
        SpringApplication.run(SSMApplication.class, args);
    }


}

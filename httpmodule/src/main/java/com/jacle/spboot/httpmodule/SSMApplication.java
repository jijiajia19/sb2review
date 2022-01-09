package com.jacle.spboot.httpmodule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication()
public class SSMApplication
{
    public static void main(String[] args)
    {
        log.info("程序开始启动:" + "start...");
        SpringApplication.run(SSMApplication.class, args);
    }


}

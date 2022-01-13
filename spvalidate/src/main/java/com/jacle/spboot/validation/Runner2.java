package com.jacle.spboot.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author Jacle
 * @version 1.0
 * @description: 第二执行器
 * @date 2022/1/13 13:36
 */
@Slf4j
public class Runner2 implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        log.info("参数--->args:{}",args);
    }
}

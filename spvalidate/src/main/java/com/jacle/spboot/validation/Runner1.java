package com.jacle.spboot.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

/**
 * @author Jacle
 * @version 1.0
 * @description: 窗口执行器
 * @date 2022/1/13 13:35
 */
@Slf4j
public class Runner1 implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        log.info("commandline arguments:{}",args);
    }
}

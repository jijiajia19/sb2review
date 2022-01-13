package com.jacle.spboot.validation.crontab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Jacle
 * @version 1.0
 * @description: 定时任务
 * @date 2022/1/13 10:26
 */
@Component
@Slf4j
public class Task
{
    private int i=0;

    @Scheduled(cron="*/6 * * * * ?")
    public void testTask()
    {
        log.info("thread id:{},FixedPrintTask execute times:{}", Thread.currentThread().getId(), ++i);
    }
}

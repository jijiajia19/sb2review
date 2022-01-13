package com.jacle.spboot.validation.crontab.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Jacle
 * @version 1.0
 * @description: Quartz定时设置
 * @date 2022/1/13 11:15
 */
@Slf4j
public class QJob extends QuartzJobBean
{
    private int i = 0;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        log.info("thread id:{},FixedPrintTask execute times:{},params{}", Thread.currentThread().getId(), ++i, jobExecutionContext.getMergedJobDataMap());

        JobDataMap jmap = jobExecutionContext.getMergedJobDataMap();
        HelloService helloService = (HelloService) jmap.get("helloService");
        log.info("result:{}", helloService.sayHello());
    }
}

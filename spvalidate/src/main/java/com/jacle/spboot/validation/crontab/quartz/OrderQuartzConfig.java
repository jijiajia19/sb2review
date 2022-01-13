package com.jacle.spboot.validation.crontab.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//独立的调用定时配置方法
public class OrderQuartzConfig
{
    @Value("${cron}")
    private String cron;

    //定义任务详情
    @Bean
    public JobDetail orderjobDetail()
    {
        //指定job的名称和持久化保存任务
        JobDataMap map = new JobDataMap();
        map.put("helloService", new HelloService());

        return JobBuilder
                .newJob(QJob.class)
                .withIdentity("orderQuartz")
                .setJobData(map)
                .storeDurably()
                .build();
    }

    //定义触发器
    @Bean
    public Trigger orderTrigger()
    {
        //表示定时任务多久执行一次
        CronScheduleBuilder scheduleBuilder
                = CronScheduleBuilder.cronSchedule(cron);
        return TriggerBuilder
                .newTrigger()
                .forJob(orderjobDetail())
                .withIdentity("orderQuartz")
                .withSchedule(scheduleBuilder).build();
    }
}

package com.jacle.spboot.validation.crontab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @author Jacle
 * @version 1.0
 * @description: 灵活控制定时任务
 * @date 2022/1/13 11:01
 */
@Configuration
@EnableScheduling
@Slf4j
public class FlexibleTask implements SchedulingConfigurer
{
    @Autowired
    private CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar)
    {
        scheduledTaskRegistrar.addTriggerTask(//1.添加任务内容(Runnable)
                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                //2.设置执行周期(Trigger)
                triggerContext ->
                {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    log.info("从数据库获取的时间{}",cron);

                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron))
                    {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }
}

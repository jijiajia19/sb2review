package com.jacle.spboot.validation.crontab.quartz;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: Quartz Config设置
 * @date 2022/1/13 13:06
 */
//@Configuration
public class QuartzConfig
{
    //构建jobdetail的两种方法MethodInvokingJobDetailFactoryBean和JobDetailFactoryBean
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean()
    {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myJob1");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBean()
    {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(QJob.class);
        JobDataMap map = new JobDataMap();
        map.put("helloService", new HelloService());
        bean.setJobDataMap(map);
        return bean;
    }

    //trigger的两种类型，一般使用第二种
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean()
    {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setStartTime(new Date());
        bean.setRepeatCount(5);
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());

        //设定周期间隔执行
        bean.setRepeatInterval(3000);
        return bean;
    }

    //配置方式设置trigger
    @Bean
    CronTriggerFactoryBean cronTrigger()
    {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("0/10 * * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean()
    {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTrigger().getObject(), simpleTriggerFactoryBean().getObject());
        return bean;
    }
}

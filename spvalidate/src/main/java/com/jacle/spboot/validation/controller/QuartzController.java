package com.jacle.spboot.validation.controller;

import com.jacle.spboot.validation.crontab.quartz.QJob2;
import com.jacle.spboot.validation.exception.ResponseResult;
import com.jacle.spboot.validation.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jacle
 * @version 1.0
 * @description: 动态新增、修改任务
 * @date 2022/1/14 9:56
 */
@Controller
@Slf4j
public class QuartzController
{
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @GetMapping("/addtask")
    @ResponseBody
    public ResponseResult addTask() throws SchedulerException
    {
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("qjob2")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .startNow()
                .build();

        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(QJob2.class)
                .withIdentity("qjob2")
                .build();

        //调度作业
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown())
        {
            scheduler.start();
            log.info("新任务创建完毕，并启动 ！jobName：[qjob2]");
        }

        return new ResponseResult(ResultEnum.SUCCESS);
    }


    @GetMapping("/gettask")
    @ResponseBody
    public ResponseResult gettask()
    {
        TriggerKey triggerKey = TriggerKey.triggerKey("qjob2");
        String name = null;
        try
        {
            Scheduler sched = schedulerFactoryBean.getScheduler();
            //STATE_BLOCKED 4 阻塞
            //STATE_COMPLETE 2 完成
            //STATE_ERROR 3 错误
            //STATE_NONE -1 不存在
            //STATE_NORMAL 0 正常
            //STATE_PAUSED 1 暂停
            Trigger.TriggerState triggerState = sched.getTriggerState(triggerKey);
            name = triggerState.name();
        } catch (Exception e)
        {
            log.error("获取任务状态失败！jobName:[qjob2]", e);
        }

        return new ResponseResult(ResultEnum.SUCCESS.getCode(), name);
    }

    @GetMapping("/removetask")
    @ResponseBody
    public ResponseResult removetask(String taskname)
    {
        TriggerKey triggerKey = TriggerKey.triggerKey(taskname);
        JobKey jobKey = JobKey.jobKey(taskname);


        try
        {
            Scheduler sched = schedulerFactoryBean.getScheduler();
            Trigger trigger = (Trigger) sched.getTrigger(triggerKey);
            if (trigger == null)
            {
                return null;
            }
            // 停止触发器
            sched.pauseTrigger(triggerKey);
            // 移除触发器
            sched.unscheduleJob(triggerKey);
            // 删除任务
            sched.deleteJob(jobKey);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return new ResponseResult(ResultEnum.SUCCESS.getCode(), "...");
    }
}

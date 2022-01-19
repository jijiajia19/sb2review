package com.jacle.spboot.httpmodule.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Jacle
 * @version 1.0
 * @description: 异步运行示例
 * @date 2022/1/19 16:10
 */
//springboot可以通过@async来进行异步设置，将同步程序变换为异步程序
//@Async所修饰的函数不要定义为static类型
@Slf4j
@Component
public class AsyncCase
{
    public static Random random = new Random();

    @Async
    public void doTask(String taskname) throws InterruptedException
    {
        log.info("开始做任务{}", taskname);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务" + taskname + "，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskTwo() throws Exception
    {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    public static void main(String[] args) throws InterruptedException
    {
        AsyncCase dcase = new AsyncCase();
        dcase.doTask("1");
        dcase.doTask("2");

    }
}

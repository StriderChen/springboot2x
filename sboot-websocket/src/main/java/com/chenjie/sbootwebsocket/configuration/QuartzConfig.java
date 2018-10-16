package com.chenjie.sbootwebsocket.configuration;

import com.chenjie.sbootwebsocket.service.SendMsgToAll;
import com.chenjie.sbootwebsocket.service.SendMsgToSingleOne;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/16 14:00
 * @Description: 这里放置的是quartz不同定时任务的配置
 */
@Component
public class QuartzConfig {
    private static final Integer ALL_CRON = 30;
    private static final Integer SINGLE_CRON = 45;

    @Autowired
    private Scheduler scheduler;

    public void SendMsgToAll() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SendMsgToAll.class)
                .withDescription("这里是发给所有人的定时任务描述,来自:jobDetail")
                .withIdentity("all-chenjie")
                .build();

        //cron表达式 表示每隔i秒执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(String.format("0/%d * * * * ? ", ALL_CRON))
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("all-chenjie", "all-chenjie")
                .withDescription("这里是发给所有人的定时任务描述,来自:cronTrigger")
                .withSchedule(scheduleBuilder)
                .startNow().build();
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }

    public void SendMsgToSingleOne() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SendMsgToSingleOne.class)
                .withDescription("这里是发给单个人的定时任务描述,来自:jobDetail")
                .withIdentity("single-chenjie")
                .build();

        //cron表达式 表示每隔i秒执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(String.format("0/%d * * * * ? ", SINGLE_CRON))
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("single-chenjie", "single-chenjie")
                .withDescription("这里是发给单个人的定时任务描述,来自:cronTrigger")
                .withSchedule(scheduleBuilder)
                .startNow().build();
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }
}

package com.chenjie.sbootquartz.scheduler;

import com.chenjie.sbootquartz.service.DoSchedule;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chenjie
 * @Date 2018/10/10 21:40
 * @Description: 定时任务的具体配置
 */
@Service
public class SchedulerConfig {

    private static final Integer CRON = 10;

    @Autowired
    private Scheduler scheduler;

    public void doScheduleTask() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(DoSchedule.class)
                .withDescription("这里是定时任务描述,来自:jobDetail")
                .withIdentity("chenjie")
                .build();

        //cron表达式 表示每隔i秒执行
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(String.format("0/%d * * * * ? ", CRON))
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("chenjie", "chenjie")
                .withDescription("这里是定时任务描述,来自:cronTrigger")
                .withSchedule(scheduleBuilder)
                .startNow().build();
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }
}
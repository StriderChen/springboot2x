package com.chenjie.sbootquartz.Listener;

import com.chenjie.sbootquartz.scheduler.SchedulerConfig;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/10 22:30
 * @Description: 定时任务入口,需要实现ApplicationListener接口
 */
@Component
public class ScheduleListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private SchedulerConfig schedulerConfig;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try {
            schedulerConfig.doScheduleTask();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

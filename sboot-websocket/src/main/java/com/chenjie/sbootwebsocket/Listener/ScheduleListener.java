package com.chenjie.sbootwebsocket.Listener;

import com.chenjie.sbootwebsocket.configuration.QuartzConfig;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/10 22:30
 * @Description: listener 定时任务入口,需要实现ApplicationListener接口
 */
@Component
public class ScheduleListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private QuartzConfig quartzConfig;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try {
            quartzConfig.SendMsgToAll();
            quartzConfig.SendMsgToSingleOne();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

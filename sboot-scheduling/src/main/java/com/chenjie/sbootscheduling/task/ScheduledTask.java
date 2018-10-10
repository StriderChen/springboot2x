package com.chenjie.sbootscheduling.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author chenjie
 * @Date 2018/10/10 23:18
 * @Description:
 */
@Component
@Slf4j
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 通过在方法上加@Scheduled注解，表明该方法是一个调度任务。
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron=”  /5   “) ：通过cron表达式定义规则，什么是cro表达式，自行搜索引擎。
     */
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("定时任务,现在时间是: {}", dateFormat.format(new Date()));
    }
}

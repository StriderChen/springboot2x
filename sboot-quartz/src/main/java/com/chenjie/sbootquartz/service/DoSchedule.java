package com.chenjie.sbootquartz.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author chenjie
 * @Date 2018/10/10 21:49
 * @Description: 定时任务的执行类, 在executeInternal方法中执行定时任务的逻辑
 */
@Slf4j
public class DoSchedule extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("任务执行的时间为:{}",System.currentTimeMillis());
        log.info("quartz定时任务的Identity:{}",jobExecutionContext.getJobDetail().getKey().getName());
        log.info("quartz定时任务描述:{}", jobExecutionContext.getJobDetail().getDescription());

    }

}

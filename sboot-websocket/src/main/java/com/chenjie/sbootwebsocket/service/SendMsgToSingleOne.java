package com.chenjie.sbootwebsocket.service;

import com.chenjie.sbootwebsocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;

/**
 * @Author chenjie
 * @Date 2018/10/10 21:49
 * @Description: 定时任务的执行类, 在executeInternal方法中执行定时任务的逻辑
 */
@Slf4j
public class SendMsgToSingleOne extends QuartzJobBean {

    private String message = "这是定时发送给某个人的消息!";
    private String cid = "2";

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("任务执行的时间为:{}",System.currentTimeMillis());
        log.info("quartz定时任务的Identity:{}",jobExecutionContext.getJobDetail().getKey().getName());

        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("编号为: {} 的消息推送失败,原因为: {}",cid,e.getMessage());
        }
        log.info("编号为: {} 的消息推送成功",cid);

    }

}

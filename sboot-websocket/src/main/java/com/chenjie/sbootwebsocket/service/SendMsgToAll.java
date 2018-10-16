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
public class SendMsgToAll extends QuartzJobBean {

    private String message = "这是定时发送给所有人的消息!";
    private String cid = null;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("任务执行的时间为:{}",System.currentTimeMillis());
        log.info("quartz定时任务描述:{}", jobExecutionContext.getJobDetail().getDescription());

        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("给所有人的消息推送失败,原因为: {}",e.getMessage());
        }
        log.info("给所有人的消息推送成功");
    }

}

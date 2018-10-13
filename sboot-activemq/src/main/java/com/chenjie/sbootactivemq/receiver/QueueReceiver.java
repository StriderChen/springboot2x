package com.chenjie.sbootactivemq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/14 0:09
 * @Description:
 */
@Component
@Slf4j
public class QueueReceiver {

    //@JmsListener(destination = "queueTest")
    @JmsListener(destination = "queueTest", containerFactory = "jmsQueueListenerContainerFactory")
    public void receive(String msg) {
        log.info("queue1 监听到的消息内容为: {} ",msg);
    }

    //@JmsListener(destination = "queueTest")
    @JmsListener(destination = "queueTest", containerFactory = "jmsQueueListenerContainerFactory")
    public void receive2(String msg) {
        log.info("queue2 监听到的消息内容为: {} ",msg);
    }
}

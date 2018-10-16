package com.chenjie.sbootmq.activemq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/14 0:16
 * @Description:
 */
@Component
@Slf4j
public class TopicReceiver {

    //@JmsListener(destination = "topicTest")
    @JmsListener(destination = "topicTest", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive(String msg) {
        log.info("topicTest1 监听到的消息内容为: {}", msg);
    }

    //@JmsListener(destination = "topicTest")
    @JmsListener(destination = "topicTest", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive2(String msg) {
        log.info("topicTest2 监听到的消息内容为: {}", msg);
    }

    /**
     * 持久订阅
     * @param msg
     */
    @JmsListener(destination = "topicTest", containerFactory = "jmsTopicListenerContainerFactory2")
    public void receive3(String msg) {
        log.info("这是topicTest 持久订阅收到的: {}", msg);
    }
}

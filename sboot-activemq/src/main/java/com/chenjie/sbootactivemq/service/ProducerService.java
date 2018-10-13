package com.chenjie.sbootactivemq.service;

import javax.jms.Destination;

/**
 * @Author chenjie
 * @Date 2018/10/13 23:24
 * @Description:
 */
public interface ProducerService {

    /**
     * Description: 指定消息队列，以及对应的消息
     *
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, String message);

}

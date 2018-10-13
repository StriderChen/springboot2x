package com.chenjie.sbootactivemq.service.impl;

import com.chenjie.sbootactivemq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Author chenjie
 * @Date 2018/10/13 23:26
 * @Description:
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate template;

    @Override
    public void sendMessage(Destination destination, String message) {
        template.convertAndSend(destination, message);
    }

}

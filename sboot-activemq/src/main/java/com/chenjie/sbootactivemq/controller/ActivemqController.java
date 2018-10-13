package com.chenjie.sbootactivemq.controller;

import com.chenjie.sbootactivemq.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @Author chenjie
 * @Date 2018/10/13 23:54
 * @Description:
 */
@RestController
public class ActivemqController {

    private static final String QUEUE_NAME = "queueTest";
    private static final String TOPIC_NAME = "topicTest";

    @Autowired
    private ProducerService producerService;

    @GetMapping("/queue")
    public void jmsQueueTemplate(@RequestParam String message) {
        Destination destination = new ActiveMQQueue(QUEUE_NAME);
        producerService.sendMessage(destination, message);
    }

    @GetMapping("/topic")
    public void jmsTopicTemplate(@RequestParam String message) {
        Destination destination = new ActiveMQTopic(TOPIC_NAME);
        producerService.sendMessage(destination, message);
    }
}

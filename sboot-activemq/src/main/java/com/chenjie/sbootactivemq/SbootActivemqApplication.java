package com.chenjie.sbootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author: chenjie
 * @date: 2018/10/13
 * @description: Springboot 整合 ActiveMQ
 */
@SpringBootApplication
@EnableJms
public class SbootActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootActivemqApplication.class, args);
    }
}

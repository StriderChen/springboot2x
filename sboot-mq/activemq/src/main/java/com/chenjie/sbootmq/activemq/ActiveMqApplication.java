package com.chenjie.sbootmq.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @Author chenjie
 * @Date 2018/10/16 18:05
 * @Description:
 */
@SpringBootApplication
@EnableJms
public class ActiveMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApplication.class);
    }
}

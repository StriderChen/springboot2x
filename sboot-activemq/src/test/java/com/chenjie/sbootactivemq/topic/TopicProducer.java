package com.chenjie.sbootactivemq.topic;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author chenjie
 * @Date 2018/10/13 15:53
 * @Description:
 */
@Slf4j
public class TopicProducer {
    private static final String URL = "tcp://127.0.0.1:61616";
    private static final String TOPIC_NAME = "topic-test";

    public static void main(String[] args) throws JMSException {

        //1.创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);

        //2.创建连接
        Connection connection = factory.createConnection();

        //3.启动连接
        connection.start();

        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        //5.创建一个主题目标
        Destination destination = session.createTopic(TOPIC_NAME);

        //6.创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 20; i++) {

            //7.创建消息
            TextMessage message = session.createTextMessage("测试创建topic消息:" + i);

            //8.发布消息
            producer.send(message);
            log.info("发送了消息:{}", message.getText());
        }

        //9.关闭连接
        connection.close();

    }

}

package com.chenjie.sboot.activemq.topic;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author chenjie
 * @Date 2018/10/13 16:31
 * @Description:
 */
@Slf4j
public class TopicConsumer {

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

        //5.创建一个目标
        Destination destination = session.createTopic(TOPIC_NAME);

        //6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //7.创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    log.info("接收到消息:{}", textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //8.关闭连接
        //connection.close();

    }
}

package com.chenjie.sbootactivemq.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;

/**
 * @Author chenjie
 * @Date 2018/10/13 23:51
 * @Description:
 */
@Configuration
public class ActiveMqConfiguration {

    private JmsMessagingTemplate template;

    @Autowired
    public ActiveMqConfiguration(JmsMessagingTemplate template) {
        this.template = template;
    }

    @Bean("jmsQueueListenerContainerFactory")
    public JmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置连接数
        //factory.setConcurrency("5-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setPubSubDomain(false);
        return factory;

    }

    @Bean("jmsTopicListenerContainerFactory")
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    /**
     * 持久订阅
     */
    @Bean("jmsTopicListenerContainerFactory2")
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory2(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setPubSubDomain(true);

        // 给订阅者一个名字,并开启持久订阅
        factory.setClientId("client_id");
        factory.setSubscriptionDurable(true);
        return factory;
    }
}

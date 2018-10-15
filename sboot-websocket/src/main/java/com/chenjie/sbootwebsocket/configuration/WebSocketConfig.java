package com.chenjie.sbootwebsocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author chenjie
 * @Date 2018/10/15 23:46
 * @Description:
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter createServerEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

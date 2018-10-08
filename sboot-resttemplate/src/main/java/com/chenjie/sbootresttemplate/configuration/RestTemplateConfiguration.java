package com.chenjie.sbootresttemplate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenjie
 * @Date 2018/10/8 21:41
 * @Description:
 */
@Configuration
public class RestTemplateConfiguration {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate setRestTemplate() {
        return restTemplateBuilder.build();
    }
}

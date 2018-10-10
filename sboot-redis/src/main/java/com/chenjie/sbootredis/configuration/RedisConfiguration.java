package com.chenjie.sbootredis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author chenjie
 * @Date 2018/10/10 15:36
 * @Description:
 */
@Configuration
public class RedisConfiguration {

    private StringRedisTemplate template;

    @Autowired
    public RedisConfiguration(StringRedisTemplate template) {
        this.template = template;
    }

}

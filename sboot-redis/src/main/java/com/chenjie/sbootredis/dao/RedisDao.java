package com.chenjie.sbootredis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author chenjie
 * @Date 2018/10/8 23:02
 * @Description:
 */
@Service
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public void setkey(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        //设置一分钟过期
        ops.set(key, value, 1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }
}

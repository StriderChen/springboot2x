package com.chenjie.sbootredis;

import com.chenjie.sbootredis.dao.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SbootRedisApplicationTests {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setkey("name", "chenjie");
        redisDao.setkey("age","27");

        log.info(redisDao.getValue("name"));
        log.info(redisDao.getValue("age"));
    }

}

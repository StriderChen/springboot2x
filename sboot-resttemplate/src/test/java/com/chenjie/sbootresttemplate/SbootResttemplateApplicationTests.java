package com.chenjie.sbootresttemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SbootResttemplateApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    private static final String TEST_URL = "http://127.0.0.1:8888/rest/hi?name=陈杰";


    @Test
    public void testRestTemplate() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(TEST_URL, String.class);
        System.out.println(forEntity.getBody());
        log.info("请求结果为:{}",forEntity.toString());
    }
}

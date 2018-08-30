package com.chenjie.springboot2x.sbootbasics.controller;

import com.chenjie.springboot2x.sbootbasics.vo.PersonProperties;
import com.chenjie.springboot2x.sbootbasics.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenjie
 * @Date 2018/8/28 21:44
 * @Description: 通过配置读取内容
 */
@RestController
@Slf4j
public class ConfigurationController {
    @Autowired
    private PersonProperties person;

    @Value("${person.name}")
    private String name;
    @Value("${person.gender}")
    private String gender;
    @Value("${person.age}")
    private Integer age;
    @Value("${person.content}")
    private String content;

    @GetMapping(value = "getConfigProperties")
    public Map<String,Object> getConfiguration() {
        log.info("姓名:", name);
        log.info("性别:", gender);
        log.info("年龄:", age);
        log.info("内容:", content);
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("gender", gender);
        map.put("age", age);
        map.put("content", content);
        map.put("person", person);
        log.warn("person",person);
        log.warn("map value::",map);

        User user = new User();
        user.setAge(18);
        user.setId(001);
        user.setName("陈杰");
        System.out.println(user);
        log.info("user::",user);
        return map;
    }

}

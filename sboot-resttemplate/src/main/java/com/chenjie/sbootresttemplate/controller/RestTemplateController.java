package com.chenjie.sbootresttemplate.controller;

import com.chenjie.sbootresttemplate.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenjie
 * @Date 2018/10/8 11:49
 * @Description:
 */
@RestController
@Slf4j
public class RestTemplateController {

    @Autowired
    private RestTemplateService service;

    @GetMapping(value = "/hi")
    public String sayHello(@RequestParam(value = "name", defaultValue = "restTemplate") String name) {
        log.info("传入的名字是:{}",name);
        return service.sayHello(name);
    }
}

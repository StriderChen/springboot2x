package com.chenjie.sbootresttemplate.service;

import org.springframework.stereotype.Service;

/**
 * @Author chenjie
 * @Date 2018/10/8 11:44
 * @Description:
 */
@Service
public class RestTemplateService {

    public String sayHello(String name) {
        return "hello: "+name;
    }
}

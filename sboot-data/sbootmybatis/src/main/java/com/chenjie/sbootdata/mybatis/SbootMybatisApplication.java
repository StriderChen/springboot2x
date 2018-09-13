package com.chenjie.sbootdata.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author chenjie
 * @Date 2018/9/13 22:01
 * @Description: springboot整合mybatis
 */
@SpringBootApplication
@MapperScan(basePackages = "com.chenjie.sbootdata.mybatis.dao")
public class SbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbootMybatisApplication.class);
    }
}

package com.chenjie.springboot2x.sbootbasics.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 72921
 * @date 2018/08/27 12:00
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class PersonProperties {
    private String name;
    private int age;
    private String gender;
}

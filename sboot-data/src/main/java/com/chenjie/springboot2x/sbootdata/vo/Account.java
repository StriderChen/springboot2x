package com.chenjie.springboot2x.sbootdata.vo;

import lombok.Data;

/**
 * @author chenjie
 * @date 2018/5/19 0:16
 * @description:
 */
@Data
public class Account {
    private int id;
    private String name;
    private Double money;
    private Integer age;
    private String address;
}

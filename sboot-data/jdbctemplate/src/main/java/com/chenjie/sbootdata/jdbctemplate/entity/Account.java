package com.chenjie.sbootdata.jdbctemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author chenjie
 * @date 2018/5/19 0:16
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String name;
    private Double money;
    private Integer age;
    private String address;

    public Account(String name, Double money, Integer age, String address) {
        this.name = name;
        this.money = money;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

package com.chenjie.springboot2x.sbootdata.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author chenjie
 * @Date 2018/9/1 13:00
 * @Description:jpa实例的实体类
 * 必须提供一个无参的构造方法,不然建表会报错
 */
@Entity
@Data
@NoArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer age;

    private String name;

    private String cpuSize;

}

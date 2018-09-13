package com.chenjie.sbootdata.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
@AllArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer age;

    private String name;

    private String cupSize;

    public Girl(Integer age,String name,String cupSize){
        this.age = age;
        this.name = name;
        this.cupSize = cupSize;
    }
    /**
     * 使用commons-lang3 的toString反射工具类,实现json格式的tostring
     * @return
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}

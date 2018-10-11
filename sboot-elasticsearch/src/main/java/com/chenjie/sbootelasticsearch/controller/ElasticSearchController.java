package com.chenjie.sbootelasticsearch.controller;

import com.chenjie.sbootelasticsearch.entity.Employee;
import com.chenjie.sbootelasticsearch.repository.EmployeeRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenjie
 * @Date 2018/10/12 0:06
 * @Description:
 */
@RestController
@Slf4j
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository er;

    /**
     * 增加
     * @param id
     * @return
     */
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id")String id){

        Employee employee=new Employee();
        employee.setId(id);
        employee.setFirstName(id+"chen");
        employee.setLastName("~");
        employee.setAge(26);
        employee.setAbout("");
        er.save(employee);

        log.info("add an obj:{}",employee);
        return "success";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete")
    public String delete(){
        Employee employee=new Employee();
        employee.setId("1");
        er.delete(employee);

        return "success";
    }

    /**
     * 局部更新
     * @return
     */
    @RequestMapping("/update")
    public String update(){

        Employee employee=er.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    /**
     * 查询
     */
    @RequestMapping("/query/{id}")
    public Employee query(@PathVariable("id")String id){

        Employee accountInfo=er.queryEmployeeById(id);
        System.err.println(new Gson().toJson(accountInfo));

        return accountInfo;
    }
}

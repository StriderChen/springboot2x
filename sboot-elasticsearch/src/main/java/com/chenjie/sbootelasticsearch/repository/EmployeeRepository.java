package com.chenjie.sbootelasticsearch.repository;

import com.chenjie.sbootelasticsearch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author chenjie
 * @Date 2018/10/12 0:05
 * @Description:
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee queryEmployeeById(String id);
}

package com.chenjie.sbootdata.jpa.repositories;


import com.chenjie.sbootdata.jpa.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author chenjie
 * @Date 2018/9/1 13:15
 * @Description jpa repositories 接口
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
}

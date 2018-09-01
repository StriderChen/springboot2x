package com.chenjie.springboot2x.sbootdata.repository;

import com.chenjie.springboot2x.sbootdata.vo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author chenjie
 * @Date 2018/9/1 13:15
 * @Description jpa repository 接口
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
}

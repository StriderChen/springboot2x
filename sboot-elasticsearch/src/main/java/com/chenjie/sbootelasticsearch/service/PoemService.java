package com.chenjie.sbootelasticsearch.service;

import com.chenjie.sbootelasticsearch.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenjie
 * @date 2018/10/11
 */
public interface PoemService {

   /**
    * 保存Poem实体
    * @param poem
    */
   void save(Poem poem);

   /**
    * 基于title和content进行搜索，返回分页
    * @param title
    * @param content
    * @param pageable
    * @return
    */
   Page<Poem> search(String title, String content, Pageable pageable);

   /**
    * 基于content进行搜索，返回分页
    * @param content
    * @param pageable
    * @return
    */
   Page<Poem> search(String content, Pageable pageable);

   /**
    * 返回所有数据集合
    * @param pageable
    * @return
    */
   Page<Poem> findAll(Pageable pageable);
}

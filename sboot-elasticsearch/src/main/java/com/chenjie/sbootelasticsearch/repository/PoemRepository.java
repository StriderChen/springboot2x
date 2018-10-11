package com.chenjie.sbootelasticsearch.repository;

import com.chenjie.sbootelasticsearch.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author chenjie
 * @date 2018/10/11
 * @description: dao层
 */
public interface PoemRepository extends ElasticsearchRepository<Poem,Long> {

    Page<Poem> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

    Page<Poem> findByContentLike(String content, Pageable pageable);

}

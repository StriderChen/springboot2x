package com.chenjie.sbootelasticsearch.service;

import com.chenjie.sbootelasticsearch.entity.Poem;
import com.chenjie.sbootelasticsearch.repository.PoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author chenjie
 * @date 2018/10/11
 */
@Service
public class PoemServiceImpl implements PoemService{

    @Autowired
    private PoemRepository poemRepository;

    @Override
    public void save(Poem poem) {
        poemRepository.save(poem);
    }

    @Override
    public Page<Poem> search(String title, String content, Pageable pageable) {
        return poemRepository.findByTitleLikeOrContentLike(title,content,pageable);
    }

    @Override
    public Page<Poem> search(String content, Pageable pageable) {
        return poemRepository.findByContentLike(content,pageable);
    }

    @Override
    public Page<Poem> findAll(Pageable pageable) {
        return poemRepository.findAll(pageable);
    }
}

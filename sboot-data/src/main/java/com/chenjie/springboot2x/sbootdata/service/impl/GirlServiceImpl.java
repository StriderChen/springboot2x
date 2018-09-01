package com.chenjie.springboot2x.sbootdata.service.impl;

import com.chenjie.springboot2x.sbootdata.repository.GirlRepository;
import com.chenjie.springboot2x.sbootdata.service.GirlService;
import com.chenjie.springboot2x.sbootdata.vo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author chenjie
 * @Date 2018/9/1 15:37
 * @Description:
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Override
    public List<Girl> findGirls() {
        List<Girl> girls = girlRepository.findAll();
        return girls;
    }

    @Override
    public Girl findAGirl(Integer id) {
        Girl girl = girlRepository.findById(id).orElse(null);
        return girl;

       /*Optional<Girl> girl = girlRepository.findById(id);
        return girl.get();*/
    }

    @Override
    public Girl addGirl(Girl girl) {
        Girl addedGirl = girlRepository.save(girl);
        return addedGirl;
    }

    @Override
    public Girl updateAGirl(Girl girl) {
        Girl updateedGirl = girlRepository.save(girl);
        return updateedGirl;
    }

    @Override
    public Girl addOrUpdate(Girl girl) {
        Girl editedGirl = girlRepository.save(girl);
        return editedGirl;
    }

    @Override
    public void deleteAGirl(Integer id) {
        girlRepository.deleteById(id);
    }
}

package com.chenjie.sbootdata.jpa.service;


import com.chenjie.sbootdata.jpa.entity.Girl;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/9/1 15:36
 * @Description:
 */
public interface GirlService {

    /**
     * 查询所有女生
     * @return
     */
    List<Girl> findGirls();

    /**
     * 根据ID查询一个女生
     * @param id
     * @return
     */
    Girl findAGirl(Integer id);

    /**
     * 增加一个女生
     * @param girl
     * @return
     */
    Girl addGirl(Girl girl);

    /**
     * 更新一个女生
     * @param girl
     * @return
     */
    Girl updateAGirl(Girl girl);

    /**
     * 新增和更新可以调用同一个方法
     * @param girl
     * @return
     */
    Girl addOrUpdate(Girl girl);

    /**
     * 根据ID删除一个女生
     * @param id
     */
    void deleteAGirl(Integer id);

}

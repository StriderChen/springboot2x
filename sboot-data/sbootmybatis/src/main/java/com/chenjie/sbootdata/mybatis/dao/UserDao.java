package com.chenjie.sbootdata.mybatis.dao;


import com.chenjie.sbootdata.mybatis.entity.User;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:11
 * @Description:
 */
public interface UserDao {
    /**
     * 增加一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 只是更新有内容的字段
     * @param user
     * @return
     */
    int insertSelective(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteById(Integer userId);

    /**
     * 根据ID查找用户
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 根据ID更新用户
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUsers();
}

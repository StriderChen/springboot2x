package com.chenjie.sbootdata.mybatis.service.impl;

import com.chenjie.sbootdata.mybatis.dao.UserDao;
import com.chenjie.sbootdata.mybatis.entity.User;
import com.chenjie.sbootdata.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:16
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer insertSelective(User user) {
        return userDao.insertSelective(user);
    }

    @Override
    public Integer deleteById(Integer userId) {
        return userDao.deleteById(userId);
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public Integer updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }


    /*@Override
    public PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.findAllUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }*/

}

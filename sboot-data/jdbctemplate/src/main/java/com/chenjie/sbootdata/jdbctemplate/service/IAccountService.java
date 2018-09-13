package com.chenjie.sbootdata.jdbctemplate.service;


import com.chenjie.sbootdata.jdbctemplate.entity.Account;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/5/19 22:08
 * @description:
 */
public interface IAccountService {

    /**
     * 增加一个账号
     * @param account
     * @return
     */
    int add(Account account);

    /**
     * 更新一个账号
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 删除一个账号
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 根据Id查询一个账号
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 查询所有账号
     * @return
     */
    List<Account> findAccountList();
}


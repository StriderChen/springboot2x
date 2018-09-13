package com.chenjie.sbootdata.jdbctemplate.service.impl;

import com.chenjie.sbootdata.jdbctemplate.dao.IAccountDao;
import com.chenjie.sbootdata.jdbctemplate.entity.Account;
import com.chenjie.sbootdata.jdbctemplate.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/5/19 22:16
 * @description:
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}

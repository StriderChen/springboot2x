package com.chenjie.springboot2x.sbootdata.dao.impl;

import com.chenjie.springboot2x.sbootdata.dao.IAccountDao;
import com.chenjie.springboot2x.sbootdata.vo.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/5/19 0:22
 * @description:
 */
@Repository
@Slf4j
public class AccountDaoDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name,money,age,address) values(?,?,?,?)",account.getName(),account.getMoney(),account.getAge(),account.getAddress());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE  account SET name=?,money=?,age=?,address=? WHERE id=?",
                account.getName(),account.getMoney(),account.getAge(),account.getAddress(),account.getId());
    }

    @Override
    public int delete(int id)    {
        return jdbcTemplate.update("DELETE from account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        List<Account> list = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper(Account.class));
        log.info("sql:",sql);
        if (list!=null && list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}

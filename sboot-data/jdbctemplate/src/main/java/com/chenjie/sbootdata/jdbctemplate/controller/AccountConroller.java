package com.chenjie.sbootdata.jdbctemplate.controller;

import com.chenjie.sbootdata.jdbctemplate.entity.Account;
import com.chenjie.sbootdata.jdbctemplate.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author chenjie
 * @Date 2018/5/19 22:54
 * @Description: 通过spring的JdbcTemplate去访问数据库
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountConroller {

    @Autowired
    private IAccountService accountService;

    /**
     * 查询所有账号
     *
     * @return
     */
    @GetMapping(value = "")
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    /**
     * 根据ID查询一个账号
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    /**
     * 更新一个账号
     * 使用put提交的时候,参数形式不能使用form-data,
     * 要使用x-www-form-urlencoded
     */
    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "money", required = false) Double money,
                                @RequestParam(value = "age", required = false) Integer age,
                                @RequestParam(value = "address", required = false) String address
    ) {
        Account account = new Account(id, name, money, age, address);
        int t = accountService.update(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "update account fail";
        }
    }

    /**
     * 增加一个账号
     *
     * @param name
     * @param money
     * @param age
     * @param address
     * @return
     */
    @PostMapping(value = "")
    public String addAccount(@RequestParam(value = "name") String name,
                             @RequestParam(value = "money") Double money,
                             @RequestParam(value = "age") Integer age,
                             @RequestParam(value = "address") String address) {
        Account account = new Account(name, money, age, address);
        int t = accountService.add(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "add account fail";
        }
    }

    /**
     * 删除一个账号
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    public Integer deleteAccountById(@PathVariable("id") Integer id) {
        int delete = accountService.delete(id);
        return delete;
    }

}

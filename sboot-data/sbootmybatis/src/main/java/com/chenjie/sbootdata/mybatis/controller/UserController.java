package com.chenjie.sbootdata.mybatis.controller;

import com.chenjie.sbootdata.mybatis.entity.User;
import com.chenjie.sbootdata.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:07
 * @Description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 增加一个用户
     *
     * @param userName
     * @param password
     * @param phone
     * @return
     */
   /* @PostMapping(value = "/")
    public Integer addUser(@RequestParam("userName") String userName,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone) {
        User user = new User(userName,password,phone);
        Integer i = userService.addUser(user);
        return i;
    }*/
    @PostMapping(value = "/")
    public Integer addUser(User user) {
        //User user = new User(userName,password,phone);
        Integer i = userService.addUser(user);
        return i;
    }

    /**
     * 查询所有的用户
     *
     * @return
     */
    @GetMapping(value = "/")
    public List<User> findAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        return allUsers;
    }


    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
   /* @GetMapping(value = "/{pageNum}/{pageSize}")
    public PageInfo<User> findAllUsers(@PathVariable(value = "pageNum") Integer pageNum,
                                       @PathVariable("pageSize") Integer pageSize) {
        PageInfo<User> allUsers = userService.findAllUsers(pageNum, pageSize);
        return allUsers;
    }
*/
    /**
     * 根据id查询一个用户
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return user;
    }


    /**
     * 根据ID删除一个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteUserById(@PathVariable(value = "id") Integer id) {
        Integer deletedId = userService.deleteById(id);
        return deletedId;
    }

    /**
     * 根据id修改用户
     * @param id
     * @param userName
     * @param password
     * @param phone
     * @return
     */
   /* @PutMapping(value = "/{id}")
    public Integer updateUserById(@PathVariable(value = "id") Integer id,
                                  @RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "phone") String phone) {
        User user = new User(id,userName,password,phone);
        Integer userId = userService.updateUserById(user);
        return userId;
    } */
    @PutMapping(value = "/{id}")
    public Integer updateUserById(@PathVariable(value = "id") Integer id,User user) {
        user.setUserId(id);
        Integer userId = userService.updateUserById(user);
        return userId;
    }

}

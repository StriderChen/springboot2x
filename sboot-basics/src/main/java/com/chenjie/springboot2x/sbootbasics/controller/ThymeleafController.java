package com.chenjie.springboot2x.sbootbasics.controller;

import com.chenjie.springboot2x.sbootbasics.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/8/28 9:53
 * @Description: 整合thymeleaf视图模板
 */
@Controller
public class ThymeleafController {

    private static final Integer USER_SIZE = 5;

    @GetMapping(value = "thymeleaf")
    public String getMeThymeleafView(@RequestParam(defaultValue = "world", required = false) String name, Model model) {
        model.addAttribute("name",name);
        List<User> userList = new ArrayList<>();
        for (Integer i = 0; i < USER_SIZE; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setAge(i + 10);
            user.setName("name" + i);
            userList.add(user);
        }
        model.addAttribute(userList);
        return "index";
    }
}

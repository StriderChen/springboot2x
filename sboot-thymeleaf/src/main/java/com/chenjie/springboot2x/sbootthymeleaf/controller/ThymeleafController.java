package com.chenjie.springboot2x.sbootthymeleaf.controller;

import com.chenjie.springboot2x.sbootthymeleaf.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/8/27 16:35
 * @Description:
 */
@Controller
public class ThymeleafController {



    @GetMapping(value = "helloThymeleaf")
    public String helloThymeleaf(@RequestParam(defaultValue = "world", required = false) String name, Model model) {
        model.addAttribute("name", name);
        List<User> userList = new ArrayList<>();
        for (Integer i =0; i<5; i++){
            User user = new User();
            user.setId(i+1);
            user.setAge(i+10);
            user.setName("name"+i);
            userList.add(user);
        }
        model.addAttribute(userList);
        return "index";
    }
}

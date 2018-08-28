package com.chenjie.springboot2x.sbootbasics.controller;

import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author chenjie
 * @Date 2018/8/28 10:49
 * @Description: 单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ThymeleafControllerTest {


    @Test
    public void testThymeleaf() {
        ThymeleafController controller = new ThymeleafController();
        assertEquals("chenjie",controller.thymeleafTest("chenjie"));
    }
}
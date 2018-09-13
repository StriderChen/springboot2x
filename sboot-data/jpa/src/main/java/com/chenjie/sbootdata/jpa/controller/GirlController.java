package com.chenjie.sbootdata.jpa.controller;

import com.chenjie.sbootdata.jpa.entity.Girl;
import com.chenjie.sbootdata.jpa.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author chenjie
 * @Date 2018/9/1 12:41
 * @Description: 用jpa实现对数据库的增删改查操作
 */
@RestController
@RequestMapping(value = "girls")
public class GirlController {

    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生
     * get请求
     * @return
     */
    @GetMapping(value = "")
    public List<Girl> findGirls() {
        List<Girl> girls = girlService.findGirls();
        return girls;
    }

    /**
     * 根据ID查询女生
     * get请求
     * @return
     */
    @GetMapping(value = "{id}")
    public Girl findGirlById(@PathVariable(value = "id") Integer id) {
        Girl girl = girlService.findAGirl(id);
        return girl;
    }

    /**
     * 添加一个女生
     * post请求
     * @return
     */
    @PostMapping(value = "")
    public Girl addGirl(@RequestParam(value = "name") String name,
                        @RequestParam(value = "age") Integer age,
                        @RequestParam(value = "cupSize") String cupSize) {
        Girl girl = new Girl(age,name,cupSize);
        Girl addedGirl = girlService.addOrUpdate(girl);

        //Girl addedGirl = girlService.addGirl(girl);
        return addedGirl;
    }

    /**
     * 更新一个女生,用put提交
     * @return
     */
    @PutMapping(value = "{id}")
    public Girl updateGirl(@PathVariable("id")Integer id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "cupSize") String cupSize) {
        Girl girl = new Girl(id,age,name,cupSize);
        Girl updateedGirl = girlService.addOrUpdate(girl);
        //Girl updateedGirl = girlService.updateAGirl(girl);
        return updateedGirl;
    }

    /**
     * 删除一个女生,用delete提交
     * 根据id
     */
    @DeleteMapping(value = "{id}")
    public void deleteAGirl(@PathVariable(value = "id") Integer id) {
        girlService.deleteAGirl(id);
    }
    

}

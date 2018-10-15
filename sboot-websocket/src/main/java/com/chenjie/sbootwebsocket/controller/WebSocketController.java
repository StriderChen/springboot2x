package com.chenjie.sbootwebsocket.controller;

import com.chenjie.sbootwebsocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author chenjie
 * @Date 2018/10/15 23:56
 * @Description:
 */
@RestController
@Slf4j
public class WebSocketController {
    /**
     * 页面请求
     * @param cid
     * @return
     */

    /**
     * 推送数据接口到所有窗口
     * @param message
     * @return
     */
    @PostMapping("/push")
    public void pushToAllWeb(String message) {
        try {
            WebSocketServer.sendInfo(message,null);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("给所有人的消息推送失败,原因为: {}",e.getMessage());
        }
        log.info("给所有人的消息推送成功");
    }

    /**
     * 推送数据接口到指定窗口
     * @param cid
     * @param message
     * @return
     */
    @PostMapping("/push/{cid}")
    public void pushToDestinationWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("编号为: {} 的消息推送失败,原因为: {}",cid,e.getMessage());
        }
        log.info("编号为: {} 的消息推送成功",cid);
    }
}

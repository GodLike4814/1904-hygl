package com.fh.controller;

import com.fh.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SendMessage sendMessage;

    @RequestMapping("/test")
    public String test(){
        sendMessage.send("这是我得第一个消息");
        return "成功";
    }
}

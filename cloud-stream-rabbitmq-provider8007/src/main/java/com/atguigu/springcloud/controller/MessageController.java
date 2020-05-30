package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baijunguang
 * @date 2020/5/29-23:34
 */
@RestController
public class MessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendmessage")
    public String send(){
       return messageProvider.send();
    }
}

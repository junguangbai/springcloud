package com.alibaba.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baijunguang
 * @date 2020/5/31-18:45
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){

        return "------------->@#$testA";

    }


    @GetMapping("/testB")
    public String testB(){

        return "------------->@#$testB ";
    }
}

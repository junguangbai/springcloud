package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baijunguang
 * @date 2020/5/27-20:48
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class,args);
    }
}

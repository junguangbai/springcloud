package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author baijunguang
 * @date 2020/5/26-16:21
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8762 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8762.class,args);
    }
}
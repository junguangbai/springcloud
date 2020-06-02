package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baijunguang
 * @date 2020/6/1-12:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosSeataOrderMain2001 {

    public static void main(String[] args) {

        SpringApplication.run(NacosSeataOrderMain2001.class,args);

    }
}

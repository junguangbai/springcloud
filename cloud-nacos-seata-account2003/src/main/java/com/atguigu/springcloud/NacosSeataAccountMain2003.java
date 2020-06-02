package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baijunguang
 * @date 2020/6/1-15:08
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class NacosSeataAccountMain2003 {

    public static void main(String[] args) {

        SpringApplication.run(NacosSeataAccountMain2003.class,args);

    }
}

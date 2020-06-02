package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baijunguang
 * @date 2020/6/1-14:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosSeataStorageMain2002 {

    public static void main(String[] args) {

        SpringApplication.run(NacosSeataStorageMain2002.class,args);

    }
}

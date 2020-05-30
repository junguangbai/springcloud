package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/30-17:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain8841 {

    public static void main(String[] args) {

        SpringApplication.run(AlibabaPaymentMain8841.class,args);

    }
}

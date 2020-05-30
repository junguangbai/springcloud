package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/30-17:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain8842 {

    public static void main(String[] args) {

        SpringApplication.run(AlibabaPaymentMain8842.class,args);

    }
}

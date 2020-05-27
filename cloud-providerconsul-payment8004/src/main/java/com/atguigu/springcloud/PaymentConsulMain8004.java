package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/27-11:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8004.class,args);
    }
}

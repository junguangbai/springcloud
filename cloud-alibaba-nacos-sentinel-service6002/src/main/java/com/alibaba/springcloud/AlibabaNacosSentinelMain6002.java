package com.alibaba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/31-18:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosSentinelMain6002 {

    public static void main(String[] args) {

        SpringApplication.run(AlibabaNacosSentinelMain6002.class,args);

    }
}

package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/30-19:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain6001 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConfigClientMain6001.class,args);

    }
}

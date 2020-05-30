package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baijunguang
 * @date 2020/5/30-18:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosConsumerMain8844 {

    public static void main(String[] args) {

        SpringApplication.run(AlibabaNacosConsumerMain8844.class,args);

    }
}

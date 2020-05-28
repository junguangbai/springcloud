package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author baijunguang
 * @date 2020/5/28-18:12
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    /**
     * 被hystrix监控的方法必须是带有@HystrixCommand注解的方法
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardMain9001.class,args);

    }
}

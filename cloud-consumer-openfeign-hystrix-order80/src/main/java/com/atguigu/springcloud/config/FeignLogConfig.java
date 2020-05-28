package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baijunguang
 * @date 2020/5/27-23:55
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL; // 最全的日志级别 NONE  BASIC HEADERS
    }
}

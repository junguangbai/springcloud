package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baijunguang
 * @date 2020/5/27-16:48
 * 注意该文件不能放在与主启动类一个包中
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        return new RoundRobinRule(); //new RandomRule(); 随机访问服务器规则，默认的是轮询规则
    }
}

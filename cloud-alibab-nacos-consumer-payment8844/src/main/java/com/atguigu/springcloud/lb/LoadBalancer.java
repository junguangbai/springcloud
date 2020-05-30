package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author baijunguang
 * @date 2020/5/27-19:20
 */
public interface LoadBalancer {

    /**
     * 获取当前一个状态是UP的服务器
     */
    public ServiceInstance instance(List<ServiceInstance> instances);
}

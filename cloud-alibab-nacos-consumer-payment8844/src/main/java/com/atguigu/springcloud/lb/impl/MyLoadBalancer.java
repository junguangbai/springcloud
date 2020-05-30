package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baijunguang
 * @date 2020/5/27-19:24
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获得一个在多线程环境下不期望被其他线程修改过的一个整形数字
     */
    public final Integer incrementAndGet(){
        Integer current;
        Integer next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1 ;
        }while(!atomicInteger.compareAndSet(current,next));
      return next;
    }

    @Override
    public ServiceInstance instance (List<ServiceInstance> instances) {
        //第几次访问
        Integer frequency = incrementAndGet();
        int instance_index = frequency % instances.size();
        ServiceInstance instance = instances.get(instance_index);
        System.out.println("第"+frequency+"次访问,访问主机为="+instance.getHost());
        return instance;
    }
}

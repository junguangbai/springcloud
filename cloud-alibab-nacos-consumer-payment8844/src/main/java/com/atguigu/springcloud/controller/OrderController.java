package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.impl.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baijunguang
 * @date 2020/5/25-17:32
 */
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-alibaba-nacos-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLoadBalancer myLoadBalancer;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        System.out.println("服务请求回来******"+result.getMessage());
        return result;
    }

    @GetMapping("/consumer/custom/payment/get/{id}")
    public CommonResult<Payment> myLoadBalancerGetData(@PathVariable("id") Long id){
        //获取该application name 下的所有服务器
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-alibaba-nacos-payment-service");
        ServiceInstance instance = myLoadBalancer.instance(instances);
        return restTemplate.getForObject(instance.getUri()+"/payment/get/"+id,CommonResult.class);
    }
}

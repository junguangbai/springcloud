package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baijunguang
 * @date 2020/5/27-21:28
 */
@RestController
@DefaultProperties(defaultFallback = "error")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/consumer/feign/hystrix/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return paymentFeignHystrixService.create(payment);
    }

    @GetMapping("/consumer/feign/hystrix/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignHystrixService.getPaymentById(id);
    }

    /**
     * 默认的fallback方法的返回类型要与该函数保持一致
     * @return
     */

    @GetMapping("/get/error/{id}")
    @HystrixCommand
    public CommonResult<Payment>  getError(@PathVariable("id") Long id){
        if(id<0){
        int temp = 1/0;
        }
        return new CommonResult<>(444,"#@$%^#$%^#@$%#@%$^$%@#$%#$%^$%&^",null);
    }

    /**
     * 全局fallback方法
     * @return
     */
    public CommonResult<Payment>  error(){

        return new CommonResult<>(444,"Global配置，系统故障",null);
    }
}

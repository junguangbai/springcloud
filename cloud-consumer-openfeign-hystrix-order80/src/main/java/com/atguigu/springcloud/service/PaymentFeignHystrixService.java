package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.PaymentFeignHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author baijunguang
 * @date 2020/5/27-21:24
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFeignHystrixServiceImpl.class)
public interface PaymentFeignHystrixService {

    @GetMapping("/payment/hystrix/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment/hystrix/create")
    public CommonResult create(@RequestBody Payment payment);
}

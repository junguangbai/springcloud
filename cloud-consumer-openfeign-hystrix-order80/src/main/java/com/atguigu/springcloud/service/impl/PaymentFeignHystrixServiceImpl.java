package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author baijunguang
 * @date 2020/5/28-15:46
 */
@Component
public class PaymentFeignHystrixServiceImpl implements PaymentFeignHystrixService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {

        return new CommonResult<>(500,"请求数据异常",null);
    }

    @Override
    public CommonResult create(Payment payment) {

        return new CommonResult<>(500,"添加数据异常",null);
    }
}

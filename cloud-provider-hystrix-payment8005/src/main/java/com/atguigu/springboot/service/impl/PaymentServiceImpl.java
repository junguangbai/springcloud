package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.PaymentDao;
import com.atguigu.springboot.service.PaymentService;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baijunguang
 * @date 2020/5/25-13:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
       //try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
        return paymentDao.getPaymentById(id);
    }
}

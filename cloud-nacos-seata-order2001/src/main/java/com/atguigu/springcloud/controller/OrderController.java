package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baijunguang
 * @date 2020/6/1-14:07
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order){

        int isSuccess = orderService.create(order);

       if(isSuccess>0){
           order.setStatus(1);
          return new CommonResult<Order>(200,"创建订单成功",order);
       }else{
          return new CommonResult<Order>(400,"创建订单失败",order);
       }
    }
}

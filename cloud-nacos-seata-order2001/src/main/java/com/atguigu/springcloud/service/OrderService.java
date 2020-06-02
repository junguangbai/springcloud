package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Order;

/**
 * @author baijunguang
 * @date 2020/6/1-13:34
 */
public interface OrderService {
    //新建订单
    public int create(Order order);

    //更新订单状态，从0改1
    public int update(Long id, Integer status);
}

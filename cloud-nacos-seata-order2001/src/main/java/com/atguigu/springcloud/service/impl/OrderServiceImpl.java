package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author baijunguang
 * @date 2020/6/1-13:36
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @GlobalTransactional
    @Override
    public int create(Order order) {

        //1.下单
        int serial = orderDao.create(order);
        System.out.println(order);
        //2.去库存
        CommonResult storageResult = storageService.decrease(order.getProductId(), order.getCount());
        System.out.println(storageResult);
        //3.扣钱
        BigDecimal money = order.getMoney();
        BigDecimal count = new BigDecimal(order.getCount().toString());
        money= money.multiply(count);
        CommonResult accountResult = accountService.decrease(order.getUserId(), money);
        System.out.println(accountResult);

        //4.更改订单状态
          order.setStatus(0);
        int update = update(order.getId(), order.getStatus());
        if(serial>0&&storageResult.getCode()==200&&accountResult.getCode()==200&&update>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int update(Long id, Integer status) {
        return orderDao.update(id,status);
    }

}

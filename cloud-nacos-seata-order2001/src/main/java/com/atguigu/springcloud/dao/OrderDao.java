package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author baijunguang
 * @date 2020/6/1-13:12
 */
@Mapper
@Repository
public interface OrderDao {

    //新建订单
    public int create(Order order);

    //更新订单状态，从0改1
    public int update(@Param("id") Long id,@Param("status") Integer status);
}

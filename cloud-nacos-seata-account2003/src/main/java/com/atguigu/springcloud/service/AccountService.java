package com.atguigu.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author baijunguang
 * @date 2020/6/1-15:22
 */
public interface AccountService {

    public void update(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

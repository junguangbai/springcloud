package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author baijunguang
 * @date 2020/6/1-15:18
 */
@Mapper
public interface AccountDao {

    public void update(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author baijunguang
 * @date 2020/6/1-14:42
 */
@Repository
@Mapper
public interface StorageDao {

    public void update(@Param("productId") Long productId, @Param("count") Integer count);
}

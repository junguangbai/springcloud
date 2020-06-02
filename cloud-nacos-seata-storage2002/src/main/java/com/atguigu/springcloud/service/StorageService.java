package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author baijunguang
 * @date 2020/6/1-14:48
 */
public interface StorageService {

    public void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Storage;
import com.atguigu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baijunguang
 * @date 2020/6/1-14:53
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;


    @PostMapping("/storage/decrease")
    public CommonResult<Storage> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult<Storage>(200,"更新库存成功count="+count,null);
    }

}

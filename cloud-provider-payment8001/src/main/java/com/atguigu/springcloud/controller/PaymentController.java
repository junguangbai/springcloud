package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baijunguang
 * @date 2020/5/25-13:18
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverport;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据成功，serverport="+serverport,result);
        }else{
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(payment!=null){
            return new CommonResult(200,"查询数据成功haha哈一再来一波哈，serverport="+serverport,payment);
        }else{
            return new CommonResult(500,"查询数据失败,没有对应记录，查询ID="+id,null);
        }
    }

    @GetMapping("/payment/get/discovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            System.out.println("服务***"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+instance.getUri()+"\t"+instance.getPort());
        }
        return this.discoveryClient.getClass();
    }
}

package com.atguigu.springboot;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author baijunguang
 * @date 2020/5/28-10:24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentHystrixMain8005 {

     public static void main(String[] args) {
             SpringApplication.run(PaymentHystrixMain8005.class,args);
         }

    /**
     * 为dasnboard而配置的
     * @return
     */
     @Bean
     public ServletRegistrationBean getServlet(){
         HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
         ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
         servletRegistrationBean.setLoadOnStartup(1);
         servletRegistrationBean.addUrlMappings("/hystrix.stream");
         servletRegistrationBean.setName("HystrixMetricsStreamServlet");
         return servletRegistrationBean;
     }
}

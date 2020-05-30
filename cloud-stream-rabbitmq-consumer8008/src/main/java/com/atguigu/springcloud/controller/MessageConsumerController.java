package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author baijunguang
 * @date 2020/5/30-10:32
 */
@Component
@EnableBinding(Sink.class)
public class MessageConsumerController {

    @Value("${server.port}")
    private String serverport;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        System.out.println("消费者1号--->"+message.getPayload()+"\t   serverport="+serverport);

    }
}

package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author baijunguang
 * @date 2020/5/29-23:03
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 该属性的名字在这里报错但是可以正常启动，要保证必须是这个名字，对应配置文件中的输出通道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("产生消息*******"+serial);
        return serial;
    }
}

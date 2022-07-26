package com.jgdabc.boot_rabbit_consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerSpringbootApplication{
    @RabbitListener(queues = "boot_rabbit_topic_qq") //指定要消费消息的队列
    public void ListenerQueue(Message message)
    {
        System.out.println(message);
    }
}

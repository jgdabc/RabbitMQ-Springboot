package com.jgdabc.rabbitconfig;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //交换机
    public static final String Exchange_Name = "boot_rabbit_topic_ee";
    public static final String Queue_Name = "boot_rabbit_topic_qqq";
    @Bean("bootExchange") //交换机的创建
    public Exchange bootExchange()
    {
        return ExchangeBuilder.topicExchange(Exchange_Name).durable(true).build(); //绑定一个topic类型的交换机，持久化并构建
    }


    @Bean("bootQueue") //队列的创建
    public Queue bootQueue()
    {
        return QueueBuilder.durable(Queue_Name).build();
    }
//    队列和交换机的绑定关系
//    哪个队列
//  哪个交换机
//    routing key
//    这里不写的话会按照方法名注入
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue,@Qualifier("bootExchange") Exchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }


}

package com.jgdabc;

import com.jgdabc.rabbitconfig.RabbitConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {


//    注入RabbitTemplate
    @Autowired
    private RabbitTemplate template;
    @Test
    public void testSend()
    {
        template.convertAndSend(RabbitConfig.Exchange_Name,"boot.haha","hi");

    }


}

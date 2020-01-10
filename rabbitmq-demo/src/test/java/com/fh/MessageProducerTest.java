package com.fh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: 1904-hygl
 * @description: 测试
 * @author: 翟浩浩
 * @create: 2020-01-10 16:04
 **/

@SpringBootTest(classes = RabbitmqDemoApplication.class)
@RunWith(SpringRunner.class)
public class MessageProducerTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void fanoutExchangeTest(){
        amqpTemplate.convertAndSend("My-Fanout-Exchange","","123");
    }
}

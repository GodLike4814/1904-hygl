package com.fh.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: 1904-hygl
 * @description: fanout策略Exchange的注入、Queue和Exchange的绑定注入
 * @author: 翟浩浩
 * @create: 2020-01-10 15:44
 **/
@Configuration
public class FanoutExchangeAndBindingConfiguration {

    @Bean(name = "myFanoutExchange")
    FanoutExchange getFanoutExchange(){
        //创建并返回名为My-Fanout-Exchange的交换机
        return new FanoutExchange("My-Fanout-Exchange");
    }

    //将myFirstExchange的队列绑定到My-Fanout-Exchange的交换机
    Binding bindingQueueOneToFanoutExchange(@Qualifier("MyFirstQueue") Queue MyFirstQueue, @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange){
        return BindingBuilder.bind(MyFirstQueue).to(myFanoutExchange);
    }

    //将myTwoExchange的队列绑定到My-Fanout-Exchange的交换机
    Binding bindingQueueTwoToFanoutExchange(@Qualifier("MyTwoQueue") Queue MyTwoQueue, @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange){
        return BindingBuilder.bind(MyTwoQueue).to(myFanoutExchange);
    }

    //将myThreeExchange的队列绑定到My-Fanout-Exchange的交换机
    Binding bindingQueueThreeToFanoutExchange(@Qualifier("MyThreeQueue") Queue MyThreeQueue, @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange){
        return BindingBuilder.bind(MyThreeQueue).to(myFanoutExchange);
    }
}

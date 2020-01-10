package com.fh.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: 1904-hygl
 * @description: Queue队列注入
 * @author: 翟浩浩
 * @create: 2020-01-10 15:38
 **/
@Configuration
public class QueueConfiguration {

    //注入第一个队列实例
    @Bean(name="MyFirstQueue")
    public Queue getFirstQueue(){
        //设置队列名为My-First-Queue
        return new Queue("My-First-Queue");
    }

    //注入第二个队列实例
    @Bean(name="MyTwoQueue")
    public Queue getTwoQueue(){
        //设置队列名为My-Two-Queue
        return new Queue("My-Two-Queue");
    }

    //注入第三个队列实例
    @Bean(name="MyThreeQueue")
    public Queue getThreeQueue(){
        //设置队列名为My-Three-Queue
        return new Queue("My-Three-Queue");
    }
}

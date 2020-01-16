package com.fh.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: 1904-hygl
 * @description: 队列配置
 * @author: 翟浩浩
 * @create: 2020-01-12 12:23
 **/
@Configuration
public class QueueConfig {

    @Bean
    public Queue createQueue(){
        return new Queue(RabbitmqConfig.QUEUE_NAME);
    }
}

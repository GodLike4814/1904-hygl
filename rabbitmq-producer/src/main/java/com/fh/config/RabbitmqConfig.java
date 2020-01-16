package com.fh.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: 1904-hygl
 * @description: 配置类
 * @author: 翟浩浩
 * @create: 2020-01-12 12:19
 **/
@Configuration
public class RabbitmqConfig {
    /**
     * 交换机名
     */
    public static final String EXCHANGE_NAME = "1904B_EXCHANGE";

    /**
     * 队列名
     */
    public static final String QUEUE_NAME = "1904B_QUEUE";

    /**
     * 路由名称
     */
    public static final String ROUTERING_KEY = "1904B_EXCHANGE_QUEUE";

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private ExchangeConfig exchangeConfig;

    @Bean
    public Binding bindingBuilder() {
        return BindingBuilder.bind(queueConfig.createQueue()).to(exchangeConfig.createExchange()).with(ROUTERING_KEY);
    }
}

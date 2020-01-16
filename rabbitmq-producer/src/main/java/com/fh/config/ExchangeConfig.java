package com.fh.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: 1904-hygl
 * @description: 交换机配置
 * @author: 翟浩浩
 * @create: 2020-01-12 12:21
 **/
@Configuration
public class ExchangeConfig {

    @Bean
    public DirectExchange createExchange(){
        return new DirectExchange(RabbitmqConfig.EXCHANGE_NAME,true,false);
    }
}

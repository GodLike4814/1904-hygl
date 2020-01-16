package com.fh.service;

import com.fh.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object obj){
        CorrelationData correlationDataId=new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,RabbitmqConfig.ROUTERING_KEY,obj,correlationDataId);
    }
}

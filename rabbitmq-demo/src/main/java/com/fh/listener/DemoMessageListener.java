package com.fh.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: 1904-hygl
 * @description: 消息消费者的具体消费方法/
 * 注入消息监听器
 * @author: 翟浩浩
 * @create: 2020-01-10 15:56
 **/
@Component
public class DemoMessageListener {

    @RabbitListener(queues = "My-First-Queue")
    public void firstConsumer(String string){
        System.out.println("我是：My-First-Queue"+"\tString:"+string);
    }

    @RabbitListener(queues = "My-Two-Queue")
    public void twoConsumer(Integer num){
        System.out.println("我是：My-Two-Queue"+"\tInteger:"+num);
    }

    @RabbitListener(queues = "My-Three-Queue")
    public void threeConsumer(String string){
        System.out.println("我是：My-Three-Queue");
    }

}

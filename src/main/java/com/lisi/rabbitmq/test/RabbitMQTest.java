package com.lisi.rabbitmq.test;


import com.lisi.rabbitmq.RabbitMqApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitMqApplication.class)
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者  直接模式
     */
    @Test
    public void test01(){
        rabbitTemplate.convertAndSend("itcast","直接模式走起");
    }

    /**
     *生产者 分列模式
     */
    @Test
    public void test02(){

        rabbitTemplate.convertAndSend("chuanzhi","","分列模式走起");
    }

    /**
     *生产者 主题模式
     */
    @Test
    public void test03(){

        rabbitTemplate.convertAndSend("topictest","goods.aaa","主题模式走起goods.aaa");
    }
    /**
     *生产者 主题模式
     */
    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","article.content.log","主题模式article.content.log");
    }

    /**
     *生产者 主题模式
     */
    @Test
    public void testSendTopic4(){
        rabbitTemplate.convertAndSend("topictest","goods.log","主题模式goods.log");
    }


}

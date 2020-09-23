package com.alibaba.lcc.utils.rabbitmq_utils;

import com.alibaba.lcc.utils.common.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

/**
 * confirm机制生产端
 */
@Slf4j
public class Procuder {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(RabbitMQConfig.RABBITMQ_HOST);
        connectionFactory.setPort(RabbitMQConfig.RABBITMQ_PORT);
        connectionFactory.setVirtualHost(RabbitMQConfig.RABBITMQ_DEFAULT_VIRTUAL_HOST);
        //2 获取Connection
        Connection connection = connectionFactory.newConnection();
        //3 通过Connection创建一个新的Channel
        Channel channel = connection.createChannel();
        //4 指定我们的消息投递模式: 消息的确认模式
        channel.confirmSelect();
        String exchangeName = "confirm_topic";  //订阅交换机  project
        String routingKey = "confirm.save";  // 路由key  confirm.#  匹配一个 topic
        //5 发送一条消息
        while(true){
            String msg = "Hello RabbitMQ Send confirm message lcc OK !"+System.currentTimeMillis();
            log.info("生产已启动，并发送了：{}", msg);
            channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
        //6 添加一个确认监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override  //deliveryTag表示消息的唯一标签，
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                log.info("-------ack!-----------");
                log.info("deliveryTag: {}, multiple: {}", deliveryTag, multiple);
            }
            @Override  //失败时进入这里
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                log.info("-------no ack!-----------");
                log.info("deliveryTag: {}, multiple: {}", deliveryTag, multiple);
            }


        });
            try {
                sleep(1000*6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

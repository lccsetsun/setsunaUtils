package com.alibaba.lcc.utils.rabbitmq_utils;

import com.alibaba.lcc.utils.common.RabbitMQConfig;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
@Slf4j
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //创建消费者
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(RabbitMQConfig.RABBITMQ_HOST);
        connectionFactory.setPort(RabbitMQConfig.RABBITMQ_PORT);
        // 设置权限 root
        connectionFactory.setVirtualHost(RabbitMQConfig.RABBITMQ_DEFAULT_VIRTUAL_HOST);
        // 建立连接  处理连接失败的异常
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel(10);
        String exchangeName = "confirm_topic";
        String topic_key = "confirm.*";
        String queue_name = "topicName";
        /**
         *  生产者 把消息发送给 交换机  消费者订阅生产（交换机）通道  产生消费
         */
        /**
         * 声明 一个类型为 type=topic 交换机
         * type类型：
         * DIRECT("direct"),
         *      所以不需要将Exchange进行任何绑定(binding)操作 。
         *      消息传递时，RouteKey必须完全匹配，
         *      才会被队列接收，否则该消息会被抛弃。
         * FANOUT("fanout"),
         *      不需要处理RouteKey 。只需要简单的将队列绑定到exchange 上。
         *      这样发送到exchange的消息都会被转发到与该交换机绑定的所有队列上。
         *      类似子网广播，每台子网内的主机都获得了一份复制的消息
         * TOPIC("topic"),
         *      将RouteKey 和某Topic 进行模糊匹配。此时队列需要绑定一个Topic。
         *      可以使用通配符进行模糊匹配，符号“#”匹配一个或多个词，
         *      符号“*”匹配不多不少一个词。
         *      因此“log.#”能够匹配到“log.info.oa”
         *      但是“log.*” 只会匹配到“log.error
         * HEADERS("headers");
         *
         */
        channel.exchangeDeclare(exchangeName,"topic",true);
        // 声明消费通道名称                 //是否持久化， 独占模式，自动删除
        channel.queueDeclare(queue_name, true, false, false, null);
//        其中'*'表示匹配一个单词， '#'则表示匹配没有或者多个单词  confirm.*
        channel.queueBind(queue_name, exchangeName, topic_key);

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume(queue_name, true, queueingConsumer);
        log.info("消费端已启动");
        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msg = new String(delivery.getBody());

            log.info("消费端: {}", msg);
        }



    }
}

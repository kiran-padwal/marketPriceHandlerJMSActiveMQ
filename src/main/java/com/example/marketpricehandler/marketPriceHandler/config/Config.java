package com.example.marketpricehandler.marketPriceHandler.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

// JMS in memory Active MQ
@Configuration
@EnableJms
@ComponentScan({"com"})
public class Config {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("inmemory.queue");
    }
}

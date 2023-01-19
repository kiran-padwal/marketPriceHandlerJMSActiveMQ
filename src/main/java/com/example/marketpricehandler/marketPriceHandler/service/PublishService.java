package com.example.marketpricehandler.marketPriceHandler.service;

import com.example.marketpricehandler.marketPriceHandler.RO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

// publisher service to add message to the JMS Queue
@Service
public class PublishService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    public String publishMessage(Message message){
        jmsTemplate.convertAndSend(queue, message.getMessage());
        return "Published Successfully";
    }
}

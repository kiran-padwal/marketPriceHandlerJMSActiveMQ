package com.example.marketpricehandler.marketPriceHandler.publisherController;

import com.example.marketpricehandler.marketPriceHandler.RO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

// publisher controller which can be used by the clients to send the message to in-mem JMS Active MQ
@RestController
@RequestMapping("/rest/publish")
public class PublisherController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") String message) {
        System.out.println(message);
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }
    @PostMapping
    public String publish(@RequestBody Message message) {
        System.out.println(message);
        jmsTemplate.convertAndSend(queue, message.getMessage());
        return "Published Successfully";
    }

}
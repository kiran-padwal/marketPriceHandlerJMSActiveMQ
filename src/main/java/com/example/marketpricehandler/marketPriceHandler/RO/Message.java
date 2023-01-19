package com.example.marketpricehandler.marketPriceHandler.RO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// request object used to publish message to the in-mem JMS Active MQ
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Message {
    private String message;
}

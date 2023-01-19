package com.example.marketpricehandler.marketPriceHandler.controller;

import com.example.marketpricehandler.marketPriceHandler.entity.MessageEntity;
import com.example.marketpricehandler.marketPriceHandler.repository.MessageRepository;
import com.example.marketpricehandler.marketPriceHandler.service.MessagePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// This is a rest controller to get the messages saved in H2 in-mem database
@RestController
@RequestMapping("/rest")
public class MessagePriceController {
    @Autowired
    private MessagePriceService messagePriceService;

    // To get all updated price which has published by the JMS in memory Active MQ
    @GetMapping("/getAllUpdatedPrice")
    public List<MessageEntity> getAllMessageEntities(){
        return messagePriceService.getAllMessageEntities();
    }

    // Get all updated price by date in descending order
    @GetMapping("/getAllUpdatedPriceOrderByDateDESC")
    public List<MessageEntity> getAllMessageEntitiesOrderByDateDESC(){
        return messagePriceService.getAllMessageEntitiesOrderByDateDESC();
    }

    // Get the latest price by instrument passed as request parameter (EUR/JPY) in url
    @RequestMapping(value = "/getLatestPriceByInstrument/**", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntity getAllMessageEntitiesOrderByDateDESC(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        String instrument = requestURL.split("/getLatestPriceByInstrument/")[1];
        return messagePriceService.getLatestPriceByInstrument(instrument);
    }
}

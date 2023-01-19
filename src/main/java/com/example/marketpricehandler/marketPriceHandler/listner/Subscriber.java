package com.example.marketpricehandler.marketPriceHandler.listner;


import com.example.marketpricehandler.marketPriceHandler.entity.MessageEntity;
import com.example.marketpricehandler.marketPriceHandler.service.MessagePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
public class Subscriber {
    @Autowired
    private MessageEntity messageEntity;

    @Autowired
    private MessagePriceService messagePriceService;

    // listens to the message in the queue whenever new message is published
    // this will be called and saved in the database
    // also it adds the adjusted price to the bid and ask price and converts the csv string to object
    // and saves the object in H2 in-mem database
    @JmsListener(destination = "inmemory.queue")
    public void onMessage(String message) throws ParseException {
        System.out.println("Received Message: " + message);
        try {
            message = message.replaceAll("\\s","");
            String[] strArray = message.split(",");
            messageEntity.setId(strArray[0]);
            messageEntity.setInstrument(strArray[1]);
            messageEntity.setBidPrice(subtractFromBid(strArray[2]));
            messageEntity.setAskPrice(addToAsk(strArray[3]));
            SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss:SSS");
            Date date= formatter.parse(strArray[4]);
            messageEntity.setTimestamp(date);
            messagePriceService.saveUpdatedPrice(messageEntity);
            System.out.print("Object With adjusted bid and ask price - ");System.out.println(messageEntity);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Message is not valid");
        }

    }
    // utility methods to add and subtracts from bid and ask price
    public String subtractFromBid(String bidPrice){
        double bidDoublePrice = Double.parseDouble(bidPrice);
        double percentValue = (0.1*bidDoublePrice)/100;
        bidDoublePrice = bidDoublePrice-percentValue;
        String strBidDoublePrice = String.valueOf(bidDoublePrice);
        return strBidDoublePrice;

    }
    public String addToAsk(String askPrice){
        double askDoublePrice = Double.parseDouble(askPrice);
        double percentValue = (0.1*askDoublePrice)/100;
        askDoublePrice = askDoublePrice+percentValue;
        String strBidDoublePrice = String.valueOf(askDoublePrice);
        return strBidDoublePrice;

    }
}
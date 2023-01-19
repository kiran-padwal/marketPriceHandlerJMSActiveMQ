package com.example.marketpricehandler.marketPriceHandler;

import com.example.marketpricehandler.marketPriceHandler.RO.Message;
import com.example.marketpricehandler.marketPriceHandler.service.PublishService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MarketPriceHandlerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MarketPriceHandlerApplication.class, args);
		PublishService publishService = context.getBean(PublishService.class);
		MarketPriceHandlerApplication marketPriceHandlerApplication = new MarketPriceHandlerApplication();
		marketPriceHandlerApplication.testMessagesPublishToMQ(publishService);
	}
// driver method to send messages to in-mem JMS Active MQ
	public String testMessagesPublishToMQ(PublishService publishService){
		//driver code for sending test messages to in memory Active MQ
		List<Message> messageList = new ArrayList<>();
		messageList.add(new Message("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001"));
		messageList.add(new Message("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002"));
		messageList.add(new Message("108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002"));
		messageList.add(new Message("109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100"));
		messageList.add(new Message("110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110"));

		for(Message message:messageList){
			publishService.publishMessage(message);
		}
		return "published messages to Queue";
	}
}

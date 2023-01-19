package com.example.marketpricehandler.marketPriceHandler;

import com.example.marketpricehandler.marketPriceHandler.entity.MessageEntity;
import com.example.marketpricehandler.marketPriceHandler.repository.MessageRepository;
import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MarketPriceHandlerApplicationTests {

	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void testGetAllMessages(){
		List<MessageEntity> messageEntityList = messageRepository.findAll();
		assertThat(messageEntityList).size().isEqualTo(0);
	}

}

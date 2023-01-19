package com.example.marketpricehandler.marketPriceHandler.service;

import com.example.marketpricehandler.marketPriceHandler.entity.MessageEntity;
import com.example.marketpricehandler.marketPriceHandler.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// service class which inserts and retrieve data from database
@Service
public class MessagePriceService {
    @Autowired
    private MessageRepository messageRepository;


    public String saveUpdatedPrice(MessageEntity messageEntity){
         messageRepository.save(messageEntity);
         return "saved updated price";
    }
    public List<MessageEntity> getAllMessageEntities(){
        return messageRepository.findAll();
    }
    public List<MessageEntity> getAllMessageEntitiesOrderByDateDESC(){
        return messageRepository.findAllByOrderByTimestampDesc();
    }

    public MessageEntity getLatestPriceByInstrument(String instrument) {
        return messageRepository.findMessageEntityByInstrumentOrderByTimestampDesc(instrument);
    }
}

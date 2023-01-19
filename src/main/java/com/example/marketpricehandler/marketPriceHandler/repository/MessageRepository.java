package com.example.marketpricehandler.marketPriceHandler.repository;
import com.example.marketpricehandler.marketPriceHandler.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

//repository interface which extends jpa repo to save and retrieve data from database
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,String> {
    List<MessageEntity> findAllByOrderByTimestampDesc();

    @Query(value = "SELECT * from message_entity where instrument=? order by timestamp desc limit 1",
    nativeQuery = true)
    MessageEntity findMessageEntityByInstrumentOrderByTimestampDesc(String instrument);
}

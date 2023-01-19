package com.example.marketpricehandler.marketPriceHandler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.sql.Timestamp;

// message model object
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table
public class MessageEntity {
    @Id
    private String id;
    private String instrument;
    private String bidPrice;
    private String askPrice;
    private Date timestamp;

}

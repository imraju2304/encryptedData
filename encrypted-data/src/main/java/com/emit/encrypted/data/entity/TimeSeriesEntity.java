package com.emit.encrypted.data.entity;// TimeSeriesEntity.java


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table
public class TimeSeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String origin;
    private String destination;
    private String secretKey;
    private String encryptedMessage;
    private Date timestamp;
}

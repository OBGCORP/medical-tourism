package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class FlightInfo extends BaseEntity {
    private String airline;
    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private Date date;
    private Integer price;
    private Patient patient;
}

package com.obg.medicaltourism.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table
@Data
public class FlightInfo extends BaseEntity {
    @Column
    private String airline;
    @Column
    private Integer flightNumber;
    @Column
    private Short seatNumber;
    @Column
    private String departureLocation;
    @Column
    private String arrivalLocation;
    @Column
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
    @Column
    private Integer price;
    @OneToOne
    @JoinColumn(name = "patient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Patient patient;
}

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
    @Column(nullable = false)
    private String airline;
    @Column(nullable = false)
    private Integer flightNumber;
    @Column(nullable = false)
    private String departureLocation;
    @Column(nullable = false)
    private String arrivalLocation;
    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
    @Column(nullable = false)
    private Integer price;
    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Patient patient;
}

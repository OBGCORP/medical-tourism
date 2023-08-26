package com.obg.medicaltourism.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
@Data
public class Reservation extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "flightInfo_id", nullable = false)
    @JsonIgnore
    private FlightInfo flightInfo;
    @Column(nullable = false)
    private Integer fl_seatNo;
    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    @JsonIgnore
    private Appointment appointment;
    @OneToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    @JsonIgnore
    private Accommodation accommodation;
    @Column(nullable = false)
    private Short acc_roomNo;
    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Patient patient;
}

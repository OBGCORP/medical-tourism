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
public class Appointment extends BaseEntity {
    @Column
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date operationDate;
    @OneToOne
    @JoinColumn(name = "clinic_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Clinic clinic;
    @OneToOne
    @JoinColumn(name = "operation_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Operation operation;
    @OneToOne
    @JoinColumn(name = "physician_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Physician physician;
    @OneToOne
    @JoinColumn(name = "patient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Patient patient;
}

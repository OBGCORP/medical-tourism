package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Appointment extends BaseEntity {
    private Date operationDate;
    private Clinic clinic;
    private Operation operation;
    private Physician physician;
    private Patient patient;
}

package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Accomodation extends BaseEntity {
    private String name;
    private String address;
    private Integer cost;
    private Patient patient;
}

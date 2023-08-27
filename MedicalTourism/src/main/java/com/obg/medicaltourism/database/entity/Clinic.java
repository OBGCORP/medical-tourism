package com.obg.medicaltourism.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
public class Clinic extends BaseEntity {
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private BigDecimal bankAccountBalance;
    @OneToMany
    @JsonIgnore
    private List<Operation> operations;
    @OneToMany
    @JsonIgnore
    private List<Physician> physicians;
}

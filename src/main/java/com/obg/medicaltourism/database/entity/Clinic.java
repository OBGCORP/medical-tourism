package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
public class Clinic extends BaseEntity {
    private String name;
    private String address;
    private BigDecimal bankAccountBalance;
    private List<Operation> operations;
    private List<Physician> physicians;
}

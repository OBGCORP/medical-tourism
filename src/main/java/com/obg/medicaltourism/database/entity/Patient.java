package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class Patient extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    private String password;
    private BigDecimal bankAccountBalance;
}

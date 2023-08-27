package com.obg.medicaltourism.database.entity;

import com.obg.medicaltourism.utility.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Operation extends BaseEntity {
    @Column
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private Integer treatmentFee;
}

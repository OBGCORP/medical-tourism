package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PatientDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private BigDecimal bankAccountBalance;
}

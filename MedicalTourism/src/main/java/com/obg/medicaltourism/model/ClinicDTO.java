package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ClinicDTO extends BaseDTO {
    private String name;
    private String address;
    private BigDecimal bankAccountBalance;
    private List<OperationDTO> operations;
    private List<PhysicianDTO> physicians;
}

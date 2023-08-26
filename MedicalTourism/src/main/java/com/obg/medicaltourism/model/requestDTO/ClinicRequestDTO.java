package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ClinicRequestDTO extends BaseDTO {
    private String name;
    private String address;
    private BigDecimal bankAccountBalance;
    private List<OperationDTO> operations;
    private List<PhysicianDTO> physicians;
}
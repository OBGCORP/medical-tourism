package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class OperationDTO extends BaseDTO {
    private String name;
    private String description;
    private Integer treatmentFee;
}

package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class OperationRequestDTO extends BaseDTO {
    private String name;
    private String description;
    private Integer treatmentFee;
}

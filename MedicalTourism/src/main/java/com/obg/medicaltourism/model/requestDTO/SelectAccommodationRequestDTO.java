package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class SelectAccommodationRequestDTO extends BaseDTO {
    private String name;
    private String address;
    private Short roomNumber;
    private Integer cost;
}

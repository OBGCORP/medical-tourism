package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class AccommodationRequestDTO extends BaseDTO {
    private String name;
    private String address;
    private Integer cost;
    private PatientDTO patient;
}

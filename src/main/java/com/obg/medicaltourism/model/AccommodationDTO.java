package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class AccommodationDTO extends BaseDTO {
    private String name;
    private String address;
    private Integer cost;
    private PatientDTO patient;
}

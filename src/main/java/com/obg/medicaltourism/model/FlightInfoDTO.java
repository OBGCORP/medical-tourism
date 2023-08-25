package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class FlightInfoDTO extends BaseDTO {
    private String airline;
    private Integer flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private Date date;
    private Integer price;
    private PatientDTO patient;
}

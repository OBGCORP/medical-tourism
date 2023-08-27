package com.obg.medicaltourism.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class FlightInfoDTO extends BaseDTO {
    private String airline;
    private Integer flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private Short seatNumber;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
    private Integer price;
    private PatientDTO patient;
}

package com.obg.medicaltourism.model.requestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class SelectFlightRequestDTO extends BaseDTO {
    private String airline;
    private Integer flightNumber;
    private Short seatNumber;
    private String departureLocation;
    private String arrivalLocation;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
    private Integer price;
}

package com.obg.medicaltourism.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO extends BaseDTO {
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date operationDate;
    private ClinicDTO clinic;
    private OperationDTO operation;
    private PhysicianDTO physician;
    private PatientDTO patient;
}

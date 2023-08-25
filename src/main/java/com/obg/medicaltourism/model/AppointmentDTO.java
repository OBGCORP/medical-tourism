package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO extends BaseDTO {
    private Date operationDate;
    private ClinicDTO clinic;
    private OperationDTO operation;
    private PhysicianDTO physician;
    private PatientDTO patient;
}

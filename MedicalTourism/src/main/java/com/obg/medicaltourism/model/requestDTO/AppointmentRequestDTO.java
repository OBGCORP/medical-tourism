package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentRequestDTO extends BaseDTO {
    private Date operationDate;
    private ClinicRequestDTO clinic;
    private OperationRequestDTO operation;
    private PhysicianRequestDTO physician;
    private PatientRequestDTO patient;
}

package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.model.ClinicDTO;
import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentRequestDTO extends BaseDTO {
    private Date operationDate;
    private ClinicDTO clinic;
    private OperationDTO operation;
    private PhysicianDTO physician;
    private PatientDTO patient;
}

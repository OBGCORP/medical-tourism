package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class ReservationDTO extends BaseDTO {
    private FlightInfoDTO flightInfoDTO;
    private AppointmentDTO appointmentDTO;
    private AccommodationDTO accommodationDTO;
    private PatientDTO patientDTO;
}

package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class ReservationDTO extends BaseDTO {
    private FlightInfoDTO flightInfoDTO;
    private Integer fl_seatNo;
    private AppointmentDTO appointmentDTO;
    private AccommodationDTO accommodationDTO;
    private Short acc_roomNo;
    private PatientDTO patientDTO;
}

package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class ReservationRequestDTO extends BaseDTO {
    private FlightInfoDTO flightInfoDTO;
    private Integer fl_seatNo;
    private AppointmentDTO appointmentDTO;
    private AccommodationDTO accommodationDTO;
    private Short acc_roomNo;
    private PatientDTO patientDTO;
}

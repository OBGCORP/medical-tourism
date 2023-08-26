package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Reservation;
import com.obg.medicaltourism.model.ReservationDTO;
import com.obg.medicaltourism.model.requestDTO.ReservationRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper implements BaseMapper<Reservation, ReservationDTO, ReservationRequestDTO> {
    private final FlightInfoMapper flightInfoMapper;
    private final AppointmentMapper appointmentMapper;
    private final AccommodationMapper accommodationMapper;
    private final PatientMapper patientMapper;

    @Autowired
    public ReservationMapper(FlightInfoMapper flightInfoMapper, AppointmentMapper appointmentMapper, AccommodationMapper accommodationMapper, PatientMapper patientMapper) {
        this.flightInfoMapper = flightInfoMapper;
        this.appointmentMapper = appointmentMapper;
        this.accommodationMapper = accommodationMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public ReservationDTO entityToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setFlightInfoDTO(flightInfoMapper.entityToDTO(reservation.getFlightInfo()));
        reservationDTO.setFl_seatNo(reservation.getFl_seatNo());
        reservationDTO.setAppointmentDTO(appointmentMapper.entityToDTO(reservation.getAppointment()));
        reservationDTO.setAccommodationDTO(accommodationMapper.entityToDTO(reservation.getAccommodation()));
        reservationDTO.setAcc_roomNo(reservation.getAcc_roomNo());
        reservationDTO.setPatientDTO(patientMapper.entityToDTO(reservation.getPatient()));
        return reservationDTO;
    }

    @Override
    public Reservation dtoToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setFlightInfo(flightInfoMapper.dtoToEntity(dto.getFlightInfoDTO()));
        reservation.setFl_seatNo(dto.getFl_seatNo());
        reservation.setAppointment(appointmentMapper.dtoToEntity(dto.getAppointmentDTO()));
        reservation.setAccommodation(accommodationMapper.dtoToEntity(dto.getAccommodationDTO()));
        reservation.setAcc_roomNo(dto.getAcc_roomNo());
        reservation.setPatient(patientMapper.dtoToEntity(dto.getPatientDTO()));
        return reservation;
    }

    @Override
    public List<ReservationDTO> entityListToDTOList(List<Reservation> reservations) {
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationDTOS.add(entityToDTO(reservation));
        }
        return reservationDTOS;
    }

    @Override
    public List<Reservation> dtoListToEntityList(List<ReservationDTO> reservationDTOS) {
        List<Reservation> reservations = new ArrayList<>();
        for (ReservationDTO reservationDTO : reservationDTOS) {
            reservations.add(dtoToEntity(reservationDTO));
        }
        return reservations;
    }

    @Override
    public Reservation requestDTOToEntity(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation();
        reservation.setFlightInfo(flightInfoMapper.dtoToEntity(reservationRequestDTO.getFlightInfoRequestDTO()));
        reservation.setFl_seatNo(reservationRequestDTO.getFl_seatNo());
        reservation.setAppointment(appointmentMapper.dtoToEntity(reservationRequestDTO.getAppointmentRequestDTO()));
        reservation.setAccommodation(accommodationMapper.dtoToEntity(reservationRequestDTO.getAccommodationRequestDTO()));
        reservation.setAcc_roomNo(reservationRequestDTO.getAcc_roomNo());
        reservation.setPatient(patientMapper.dtoToEntity(reservationRequestDTO.getPatientRequestDTO()));
        return reservation;
    }

    @Override
    public List<Reservation> requestDTOListToEntityList(List<ReservationRequestDTO> reservationRequestDTOS) {
        List<Reservation> reservations = new ArrayList<>();
        for (ReservationRequestDTO reservationRequestDTO : reservationRequestDTOS) {
                    reservations.add(requestDTOToEntity(reservationRequestDTO));
        }
        return reservations;
    }

    @Override
    public Reservation requestDTOToExistEntity(ReservationRequestDTO reservationRequestDTO, Reservation entity) {
        Reservation reservation = new Reservation();
        reservation.setId(entity.getId());
        reservation.setFlightInfo(flightInfoMapper.dtoToEntity(reservationRequestDTO.getFlightInfoRequestDTO()));
        reservation.setFl_seatNo(reservationRequestDTO.getFl_seatNo());
        reservation.setAppointment(appointmentMapper.dtoToEntity(reservationRequestDTO.getAppointmentRequestDTO()));
        reservation.setAccommodation(accommodationMapper.dtoToEntity(reservationRequestDTO.getAccommodationRequestDTO()));
        reservation.setAcc_roomNo(reservationRequestDTO.getAcc_roomNo());
        reservation.setPatient(patientMapper.dtoToEntity(reservationRequestDTO.getPatientRequestDTO()));
        return reservation;
    }
}

package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Reservation;
import com.obg.medicaltourism.database.repository.ReservationRepository;
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

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationMapper(FlightInfoMapper flightInfoMapper, AppointmentMapper appointmentMapper, AccommodationMapper accommodationMapper, PatientMapper patientMapper, ReservationRepository reservationRepository) {
        this.flightInfoMapper = flightInfoMapper;
        this.appointmentMapper = appointmentMapper;
        this.accommodationMapper = accommodationMapper;
        this.patientMapper = patientMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationDTO entityToDTO(Reservation reservationInit) {
        Reservation reservation = reservationRepository.findById(reservationInit.getId()).orElse(null);
        if (reservation != null) {
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setId(reservation.getId());
            reservationDTO.setUuid(reservation.getUuid());
            reservationDTO.setCreationDate(reservation.getCreationDate());
            if (reservation.getFlightInfo() != null) {
                reservationDTO.setFlightInfoDTO(flightInfoMapper.entityToDTO(reservation.getFlightInfo()));
            }
            if (reservation.getAppointment() != null) {
                reservationDTO.setAppointmentDTO(appointmentMapper.entityToDTO(reservation.getAppointment()));
            }
            if (reservation.getAccommodation() != null) {
                reservationDTO.setAccommodationDTO(accommodationMapper.entityToDTO(reservation.getAccommodation()));
            }
            if (reservation.getPatient() != null) {
                reservationDTO.setPatientDTO(patientMapper.entityToDTO(reservation.getPatient()));
            }
            return reservationDTO;
        } else {
            return null;
        }
    }

    @Override
    public Reservation dtoToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setUuid(dto.getUuid());
        reservation.setCreationDate(dto.getCreationDate());
        reservation.setUpdatedDate(dto.getUpdatedDate());
        if (dto.getFlightInfoDTO() != null) {
            reservation.setFlightInfo(flightInfoMapper.dtoToEntity(dto.getFlightInfoDTO()));
        }
        if (dto.getAppointmentDTO() != null) {
            reservation.setAppointment(appointmentMapper.dtoToEntity(dto.getAppointmentDTO()));
        }
        if (dto.getAccommodationDTO() != null) {
            reservation.setAccommodation(accommodationMapper.dtoToEntity(dto.getAccommodationDTO()));
        }
        if (dto.getPatientDTO() != null) {
            reservation.setPatient(patientMapper.dtoToEntity(dto.getPatientDTO()));
        }
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
        if (reservationRequestDTO.getFlightInfoDTO() != null) {
            reservation.setFlightInfo(flightInfoMapper.dtoToEntity(reservationRequestDTO.getFlightInfoDTO()));
        }
        if (reservationRequestDTO.getAppointmentDTO() != null) {
            reservation.setAppointment(appointmentMapper.dtoToEntity(reservationRequestDTO.getAppointmentDTO()));
        }
        if (reservationRequestDTO.getAccommodationDTO() != null) {
            reservation.setAccommodation(accommodationMapper.dtoToEntity(reservationRequestDTO.getAccommodationDTO()));
        }
        if (reservationRequestDTO.getPatientDTO() != null) {
            reservation.setPatient(patientMapper.dtoToEntity(reservationRequestDTO.getPatientDTO()));
        }
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
        if (reservationRequestDTO.getFlightInfoDTO() != null) {
            reservation.setFlightInfo(flightInfoMapper.dtoToEntity(reservationRequestDTO.getFlightInfoDTO()));
        }
        if (reservationRequestDTO.getAppointmentDTO() != null) {
            reservation.setAppointment(appointmentMapper.dtoToEntity(reservationRequestDTO.getAppointmentDTO()));
        }
        if (reservationRequestDTO.getAccommodationDTO() != null) {
            reservation.setAccommodation(accommodationMapper.dtoToEntity(reservationRequestDTO.getAccommodationDTO()));
        }
        if (reservationRequestDTO.getPatientDTO() != null) {
            reservation.setPatient(patientMapper.dtoToEntity(reservationRequestDTO.getPatientDTO()));
        }
        return reservation;
    }
}
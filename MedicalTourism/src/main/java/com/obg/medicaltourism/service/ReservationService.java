package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.*;
import com.obg.medicaltourism.database.repository.*;
import com.obg.medicaltourism.mapper.*;
import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.ReservationDTO;
import com.obg.medicaltourism.model.requestDTO.ReservationRequestDTO;
import com.obg.medicaltourism.model.requestDTO.SelectAccommodationRequestDTO;
import com.obg.medicaltourism.model.requestDTO.SelectFlightRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
@EnableScheduling
public class ReservationService extends BaseService<Reservation, ReservationDTO, ReservationRequestDTO, ReservationMapper, ReservationRepository> {
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;
    private final OperationMapper operationMapper;
    private final OperationRepository operationRepository;
    private final ClinicMapper clinicMapper;
    private final ClinicRepository clinicRepository;
    private final ClinicService clinicService;
    private final PhysicianMapper physicianMapper;
    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    public ReservationService(ReservationMapper reservationMapper,
                              ReservationRepository reservationRepository,
                              PatientMapper patientMapper,
                              PatientRepository patientRepository,
                              OperationMapper operationMapper,
                              OperationRepository operationRepository,
                              ClinicMapper clinicMapper,
                              ClinicRepository clinicRepository,
                              ClinicService clinicService,
                              PhysicianMapper physicianMapper) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
        this.clinicMapper = clinicMapper;
        this.clinicRepository = clinicRepository;
        this.clinicService = clinicService;
        this.physicianMapper = physicianMapper;
    }

    @Override
    public ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    public ReservationRepository getRepository() {
        return reservationRepository;
    }

    public Optional<ReservationDTO> selectOperation(Long operationId, Long patientId, Date operationDate) {
        Optional<Operation> operation = operationRepository.findById(operationId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (operation.isPresent() && patient.isPresent()) {
            ReservationDTO reservationDTO = new ReservationDTO();
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            reservationDTO.setAppointmentDTO(appointmentDTO);
            reservationDTO.setPatientDTO(patientMapper.entityToDTO(patient.get()));
            reservationDTO.getAppointmentDTO().setOperationDate(operationDate);
            reservationDTO.getAppointmentDTO().setOperation(operationMapper.entityToDTO(operation.get()));
            reservationDTO.getAppointmentDTO().setPatient(reservationDTO.getPatientDTO());

            reservationDTO.getPatientDTO().setBankAccountBalance(
                    reservationDTO.getPatientDTO().getBankAccountBalance().subtract(
                            BigDecimal.valueOf(reservationDTO.getAppointmentDTO().getOperation().getTreatmentFee())
                    ));

            getRepository().save(getMapper().dtoToEntity(reservationDTO));
            return Optional.of(reservationDTO);
        } else {
            return Optional.empty();
        }
    }

    public Optional<ReservationDTO> selectClinic(Long reservationId, Long clinicId) {
        Optional<Reservation> reservation = getRepository().findById(reservationId);
        Optional<Clinic> clinic = clinicRepository.findById(clinicId);
        if (reservation.isPresent() && clinic.isPresent()) {
            ReservationDTO reservationDTO = getMapper().entityToDTO(reservation.get());
            reservationDTO.getAppointmentDTO().setClinic(clinicMapper.entityToDTO(clinic.get()));

            reservationDTO.getAppointmentDTO().getClinic().setBankAccountBalance(
                    reservationDTO.getAppointmentDTO().getClinic().getBankAccountBalance()
                            .add(BigDecimal.valueOf(reservationDTO.getAppointmentDTO().getOperation().getTreatmentFee())));

            getRepository().save(getMapper().dtoToEntity(reservationDTO));
            return Optional.of(reservationDTO);
        } else {
            return Optional.empty();
        }
    }

    public Optional<ReservationDTO> selectPhysician(Long reservationId, Long physicianId) {
        Optional<Reservation> reservation = getRepository().findById(reservationId);
        if (reservation.isPresent()) {
            ReservationDTO reservationDTO = getMapper().entityToDTO(reservation.get());
            Optional<Physician> physician = clinicService.findPhysicianById(physicianId, reservation.get().getAppointment().getClinic().getId());
            if (physician.isPresent()) {
                reservationDTO.getAppointmentDTO().setPhysician(physicianMapper.entityToDTO(physician.get()));
                getRepository().save(getMapper().dtoToEntity(reservationDTO));
                return Optional.of(reservationDTO);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<ReservationDTO> selectFlight(Long reservationId, SelectFlightRequestDTO selectFlightRequestDTO) {
        Optional<Reservation> reservation = getRepository().findById(reservationId);
        if (reservation.isPresent()) {
            ReservationDTO reservationDTO = getMapper().entityToDTO(reservation.get());
            FlightInfoDTO flightInfoDTO = new FlightInfoDTO();
            reservationDTO.setFlightInfoDTO(flightInfoDTO);
            reservationDTO.getFlightInfoDTO().setPatient(reservationDTO.getPatientDTO());
            reservationDTO.getFlightInfoDTO().setAirline(selectFlightRequestDTO.getAirline());
            reservationDTO.getFlightInfoDTO().setFlightNumber(selectFlightRequestDTO.getFlightNumber());
            reservationDTO.getFlightInfoDTO().setDepartureLocation(selectFlightRequestDTO.getDepartureLocation());
            reservationDTO.getFlightInfoDTO().setArrivalLocation(selectFlightRequestDTO.getArrivalLocation());
            reservationDTO.getFlightInfoDTO().setDate(selectFlightRequestDTO.getDate());
            reservationDTO.getFlightInfoDTO().setPrice(selectFlightRequestDTO.getPrice());
            reservationDTO.getFlightInfoDTO().setSeatNumber(selectFlightRequestDTO.getSeatNumber());

            reservationDTO.getPatientDTO().setBankAccountBalance(
                    reservationDTO.getPatientDTO().getBankAccountBalance().subtract(
                            BigDecimal.valueOf(reservationDTO.getFlightInfoDTO().getPrice())
                    ));

            getRepository().save(getMapper().dtoToEntity(reservationDTO));
            return Optional.of(reservationDTO);
        } else {
            return Optional.empty();
        }
    }

    public Optional<ReservationDTO> selectAccommodation(Long reservationId, SelectAccommodationRequestDTO selectAccommodationRequestDTO) {
        Optional<Reservation> reservation = getRepository().findById(reservationId);
        if (reservation.isPresent()) {
            ReservationDTO reservationDTO = getMapper().entityToDTO(reservation.get());
            AccommodationDTO accommodationDTO = new AccommodationDTO();
            reservationDTO.setAccommodationDTO(accommodationDTO);
            reservationDTO.getAccommodationDTO().setPatient(reservationDTO.getPatientDTO());
            reservationDTO.getAccommodationDTO().setCost(selectAccommodationRequestDTO.getCost());
            reservationDTO.getAccommodationDTO().setName(selectAccommodationRequestDTO.getName());
            reservationDTO.getAccommodationDTO().setAddress(selectAccommodationRequestDTO.getAddress());
            reservationDTO.getAccommodationDTO().setRoomNumber(selectAccommodationRequestDTO.getRoomNumber());

            reservationDTO.getPatientDTO().setBankAccountBalance(
                    reservationDTO.getPatientDTO().getBankAccountBalance().subtract(
                            BigDecimal.valueOf(reservationDTO.getAccommodationDTO().getCost())
                    ));

            getRepository().save(getMapper().dtoToEntity(reservationDTO));
            return Optional.of(reservationDTO);
        } else {
            return Optional.empty();
        }
    }

    @Scheduled(fixedRate = 100000)
    public void checkReservation() {
        for (Reservation reservation : getRepository().findAll()) {
            if (reservation.getAppointment() == null ||
                    reservation.getAppointment().getClinic() == null ||
                    reservation.getAppointment().getPhysician() == null ||
                    reservation.getFlightInfo() == null ||
                    reservation.getAccommodation() == null) {
                getRepository().delete(reservation);
                log.info("Reservation with id: " + reservation.getId() + " is deleted.");
            }
        }
    }
}
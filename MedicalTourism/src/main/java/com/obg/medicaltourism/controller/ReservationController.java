package com.obg.medicaltourism.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obg.medicaltourism.database.entity.Reservation;
import com.obg.medicaltourism.database.repository.ReservationRepository;
import com.obg.medicaltourism.mapper.ReservationMapper;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.ReservationDTO;
import com.obg.medicaltourism.model.requestDTO.ReservationRequestDTO;
import com.obg.medicaltourism.model.requestDTO.SelectAccommodationRequestDTO;
import com.obg.medicaltourism.model.requestDTO.SelectFlightRequestDTO;
import com.obg.medicaltourism.service.ReservationService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController extends BaseController<Reservation, ReservationDTO, ReservationRequestDTO, ReservationMapper, ReservationRepository, ReservationService> {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    protected ReservationService getService() {
        return reservationService;
    }

    @PostMapping("/select-operation")
    public ResponseEntity<Optional<ReservationDTO>> selectOperation(@RequestParam Long patientId, @RequestParam Long operationId, @RequestBody @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss") Date operationDate) {
        Optional<ReservationDTO> reservationDTO = reservationService.selectOperation(operationId, patientId, operationDate);
        if (reservationDTO.isPresent()) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/select-clinic")
    public ResponseEntity<Optional<ReservationDTO>> selectClinic(@RequestParam Long reservationId, @RequestBody Long clinicId) {
        Optional<ReservationDTO> reservationDTO = reservationService.selectClinic(reservationId, clinicId);
        if (reservationDTO.isPresent()) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/select-physician")
    public ResponseEntity<Optional<ReservationDTO>> selectPhysician(@RequestParam Long reservationId, @RequestBody Long physicianId) {
        Optional<ReservationDTO> reservationDTO = reservationService.selectPhysician(reservationId, physicianId);
        if (reservationDTO.isPresent()) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/select-flight")
    public ResponseEntity<Optional<ReservationDTO>> selectFlight(@RequestParam Long reservationId, @RequestBody SelectFlightRequestDTO selectFlightRequestDTO) {
        Optional<ReservationDTO> reservationDTO = reservationService.selectFlight(reservationId, selectFlightRequestDTO);
        if (reservationDTO.isPresent()) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/select-accommodation")
    public ResponseEntity<Optional<ReservationDTO>> selectAccommodation(@RequestParam Long reservationId, @RequestBody SelectAccommodationRequestDTO selectAccommodationRequestDTO) {
        Optional<ReservationDTO> reservationDTO = reservationService.selectAccommodation(reservationId, selectAccommodationRequestDTO);
        if (reservationDTO.isPresent()) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

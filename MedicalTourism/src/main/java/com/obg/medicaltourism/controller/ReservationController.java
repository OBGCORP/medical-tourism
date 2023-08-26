package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Reservation;
import com.obg.medicaltourism.database.repository.ReservationRepository;
import com.obg.medicaltourism.mapper.ReservationMapper;
import com.obg.medicaltourism.model.ReservationDTO;
import com.obg.medicaltourism.model.requestDTO.ReservationRequestDTO;
import com.obg.medicaltourism.service.ReservationService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

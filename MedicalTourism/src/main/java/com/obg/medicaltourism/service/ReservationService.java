package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Reservation;
import com.obg.medicaltourism.database.repository.ReservationRepository;
import com.obg.medicaltourism.mapper.ReservationMapper;
import com.obg.medicaltourism.model.ReservationDTO;
import com.obg.medicaltourism.model.requestDTO.ReservationRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends BaseService<Reservation, ReservationDTO, ReservationRequestDTO, ReservationMapper, ReservationRepository> {
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    public ReservationRepository getRepository() {
        return reservationRepository;
    }
}

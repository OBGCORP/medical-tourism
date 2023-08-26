package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Accommodation;
import com.obg.medicaltourism.database.repository.AccommodationRepository;
import com.obg.medicaltourism.mapper.AccommodationMapper;
import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.requestDTO.AccommodationRequestDTO;
import com.obg.medicaltourism.service.AccommodationService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController extends BaseController<Accommodation, AccommodationDTO, AccommodationRequestDTO, AccommodationMapper, AccommodationRepository, AccommodationService> {

    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    protected AccommodationService getService() {
        return accommodationService;
    }

}

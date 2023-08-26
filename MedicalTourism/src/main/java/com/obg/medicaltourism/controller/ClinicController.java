package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Clinic;
import com.obg.medicaltourism.database.repository.ClinicRepository;
import com.obg.medicaltourism.mapper.ClinicMapper;
import com.obg.medicaltourism.model.ClinicDTO;
import com.obg.medicaltourism.model.requestDTO.ClinicRequestDTO;
import com.obg.medicaltourism.service.ClinicService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinics")
public class ClinicController extends BaseController<Clinic, ClinicDTO, ClinicRequestDTO, ClinicMapper, ClinicRepository, ClinicService> {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    protected ClinicService getService() {
        return clinicService;
    }

}

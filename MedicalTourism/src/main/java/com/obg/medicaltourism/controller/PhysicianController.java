package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.database.repository.PhysicianRepository;
import com.obg.medicaltourism.mapper.PhysicianMapper;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.model.requestDTO.PhysicianRequestDTO;
import com.obg.medicaltourism.service.PhysicianService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/physicians")
public class PhysicianController extends BaseController<Physician, PhysicianDTO, PhysicianRequestDTO, PhysicianMapper, PhysicianRepository, PhysicianService> {

    private final PhysicianService physicianService;

    @Autowired
    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    @Override
    protected PhysicianService getService() {
        return physicianService;
    }

}

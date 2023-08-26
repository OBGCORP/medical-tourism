package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.database.repository.PhysicianRepository;
import com.obg.medicaltourism.mapper.PhysicianMapper;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.model.requestDTO.PhysicianRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PhysicianService extends BaseService<Physician, PhysicianDTO, PhysicianRequestDTO, PhysicianMapper, PhysicianRepository> {

    private final PhysicianMapper physicianMapper;
    private final PhysicianRepository physicianRepository;

    @Autowired
    public PhysicianService(PhysicianMapper physicianMapper, PhysicianRepository physicianRepository) {
        this.physicianMapper = physicianMapper;
        this.physicianRepository = physicianRepository;
    }

    @Override
    public PhysicianMapper getMapper() {
        return physicianMapper;
    }

    @Override
    public PhysicianRepository getRepository() {
        return physicianRepository;
    }

    public Page<PhysicianDTO> getAllPhysiciansWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Physician> physicians = physicianRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return physicians.map(physicianMapper::entityToDTO);
    }

}

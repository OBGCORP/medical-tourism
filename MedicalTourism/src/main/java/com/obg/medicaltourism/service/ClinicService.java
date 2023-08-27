package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Clinic;
import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.database.repository.ClinicRepository;
import com.obg.medicaltourism.mapper.ClinicMapper;
import com.obg.medicaltourism.model.ClinicDTO;
import com.obg.medicaltourism.model.requestDTO.ClinicRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicService extends BaseService<Clinic, ClinicDTO, ClinicRequestDTO, ClinicMapper, ClinicRepository> {

    private final ClinicMapper clinicMapper;
    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicMapper clinicMapper, ClinicRepository clinicRepository) {
        this.clinicMapper = clinicMapper;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public ClinicMapper getMapper() {
        return clinicMapper;
    }

    @Override
    public ClinicRepository getRepository() {
        return clinicRepository;
    }

    public Page<ClinicDTO> getAllClinicsWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Clinic> clinics = clinicRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return clinics.map(clinicMapper::entityToDTO);
    }

    public Optional<Physician> findPhysicianById(Long physicianId, Long clinicId) {
        Optional<Clinic> clinic = clinicRepository.findById(clinicId);
        if (clinic.isPresent() && clinic.get().getPhysicians() != null) {
            for (Physician physician : clinic.get().getPhysicians()) {
                if (physician.getId().equals(physicianId)) {
                    return Optional.of(physician);
                }
            }
        }
        return Optional.empty();
    }

}

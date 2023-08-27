package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.database.repository.PatientRepository;
import com.obg.medicaltourism.mapper.PatientMapper;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient, PatientDTO, PatientRequestDTO, PatientMapper, PatientRepository> {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    public PatientRepository getRepository() {
        return patientRepository;
    }

    public Page<PatientDTO> getAllPatientsWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Patient> patients = patientRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return patients.map(patientMapper::entityToDTO);
    }

    public PatientDTO register(PatientRequestDTO patientRequestDTO) {
        return null;
    }

    public PatientDTO login(PatientRequestDTO patientRequestDTO) {
        return null;
    }
}

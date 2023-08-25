package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientMapper implements BaseMapper<Patient, PatientDTO, PatientRequestDTO> {
    @Override
    public PatientDTO entityToDTO(Patient entity) {
        return null;
    }

    @Override
    public Patient dtoToEntity(PatientDTO dto) {
        return null;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<Patient> patients) {
        return null;
    }

    @Override
    public List<Patient> dtoListToEntityList(List<PatientDTO> patientDTOS) {
        return null;
    }

    @Override
    public Patient requestDTOToEntity(PatientRequestDTO patientRequestDTO) {
        return null;
    }

    @Override
    public List<Patient> requestDTOListToEntityList(List<PatientRequestDTO> patientRequestDTOS) {
        return null;
    }

    @Override
    public Patient requestDTOToExistEntity(PatientRequestDTO patientRequestDTO, Patient entity) {
        return null;
    }
}

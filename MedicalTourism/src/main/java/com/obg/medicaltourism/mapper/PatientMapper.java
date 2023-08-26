package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper implements BaseMapper<Patient, PatientDTO, PatientRequestDTO> {
    @Override
    public PatientDTO entityToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setUuid(patient.getUuid());
        patientDTO.setId(patient.getId());
        patientDTO.setCreationDate(patient.getCreationDate());
        patientDTO.setUpdatedDate(patient.getUpdatedDate());
        patientDTO.setName(patient.getName());
        patientDTO.setSurname(patient.getSurname());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setPassword(patient.getPassword());
        patientDTO.setBankAccountBalance(patient.getBankAccountBalance());
        return patientDTO;
    }

    @Override
    public Patient dtoToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setUuid(dto.getUuid());
        patient.setId(dto.getId());
        patient.setCreationDate(dto.getCreationDate());
        patient.setUpdatedDate(dto.getUpdatedDate());
        patient.setName(dto.getName());
        patient.setSurname(dto.getSurname());
        patient.setEmail(dto.getEmail());
        patient.setPassword(dto.getPassword());
        patient.setBankAccountBalance(dto.getBankAccountBalance());
        return patient;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<Patient> patients) {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(entityToDTO(patient));
        }
        return patientDTOS;
    }

    @Override
    public List<Patient> dtoListToEntityList(List<PatientDTO> patientDTOS) {
        List<Patient> patients = new ArrayList<>();
        for (PatientDTO patientDTO : patientDTOS) {
            patients.add(dtoToEntity(patientDTO));
        }
        return patients;
    }

    @Override
    public Patient requestDTOToEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setSurname(patientRequestDTO.getSurname());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPassword(patientRequestDTO.getPassword());
        patient.setBankAccountBalance(patientRequestDTO.getBankAccountBalance());
        return patient;
    }

    @Override
    public List<Patient> requestDTOListToEntityList(List<PatientRequestDTO> patientRequestDTOS) {
        List<Patient> patients = new ArrayList<>();
        for (PatientRequestDTO patientRequestDTO : patientRequestDTOS) {
            patients.add(requestDTOToEntity(patientRequestDTO));
        }
        return patients;
    }

    @Override
    public Patient requestDTOToExistEntity(PatientRequestDTO patientRequestDTO, Patient patient) {
        patient.setName(patientRequestDTO.getName());
        patient.setSurname(patientRequestDTO.getSurname());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPassword(patientRequestDTO.getPassword());
        patient.setBankAccountBalance(patientRequestDTO.getBankAccountBalance());
        return patient;
    }
}

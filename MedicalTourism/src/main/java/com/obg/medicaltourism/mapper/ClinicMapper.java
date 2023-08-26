package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Clinic;
import com.obg.medicaltourism.database.repository.ClinicRepository;
import com.obg.medicaltourism.database.repository.OperationRepository;
import com.obg.medicaltourism.database.repository.PhysicianRepository;
import com.obg.medicaltourism.model.ClinicDTO;
import com.obg.medicaltourism.model.requestDTO.ClinicRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClinicMapper implements BaseMapper<Clinic, ClinicDTO, ClinicRequestDTO> {
    private final ClinicRepository clinicRepository;
    private final PhysicianRepository physicianRepository;
    private final OperationRepository operationRepository;
    private final PhysicianMapper physicianMapper;
    private final OperationMapper operationMapper;

    @Autowired
    @Lazy
    public ClinicMapper(PhysicianMapper physicianMapper,
                        OperationMapper operationMapper,
                        PhysicianRepository physicianRepository,
                        OperationRepository operationRepository,
                        ClinicRepository clinicRepository) {
        this.physicianMapper = physicianMapper;
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
        this.physicianRepository = physicianRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public ClinicDTO entityToDTO(Clinic clinicInit) {
        Clinic clinic = clinicRepository.findById(clinicInit.getId()).orElse(null);
        if (clinic != null) {
            ClinicDTO clinicDTO = new ClinicDTO();
            clinicDTO.setUuid(clinic.getUuid());
            clinicDTO.setId(clinic.getId());
            clinicDTO.setCreationDate(clinic.getCreationDate());
            clinicDTO.setUpdatedDate(clinic.getUpdatedDate());
            clinicDTO.setName(clinic.getName());
            clinicDTO.setAddress(clinic.getAddress());
            clinicDTO.setBankAccountBalance(clinic.getBankAccountBalance());
            clinicDTO.setPhysicians(physicianMapper.entityListToDTOList(clinic.getPhysicians()));
            clinicDTO.setOperations(operationMapper.entityListToDTOList(clinic.getOperations()));
            return clinicDTO;
        } else {
            return null;
        }
    }

    @Override
    public Clinic dtoToEntity(ClinicDTO dto) {
        Clinic clinic = new Clinic();
        clinic.setUuid(dto.getUuid());
        clinic.setId(dto.getId());
        clinic.setCreationDate(dto.getCreationDate());
        clinic.setUpdatedDate(dto.getUpdatedDate());
        clinic.setName(dto.getName());
        clinic.setAddress(dto.getAddress());
        clinic.setBankAccountBalance(dto.getBankAccountBalance());
        if (dto.getPhysicians() != null && dto.getOperations() != null) {
            clinic.setPhysicians(physicianMapper.dtoListToEntityList(dto.getPhysicians()));
            clinic.setOperations(operationMapper.dtoListToEntityList(dto.getOperations()));
        }
        return clinic;
    }

    @Override
    public List<ClinicDTO> entityListToDTOList(List<Clinic> clinics) {
        List<ClinicDTO> clinicDTOS = new ArrayList<>();
        for (Clinic clinic : clinics) {
            clinicDTOS.add(entityToDTO(clinic));
        }
        return clinicDTOS;
    }

    @Override
    public List<Clinic> dtoListToEntityList(List<ClinicDTO> clinicDTOS) {
        List<Clinic> clinics = new ArrayList<>();
        for (ClinicDTO clinicDTO : clinicDTOS) {
            clinics.add(dtoToEntity(clinicDTO));
        }
        return clinics;
    }

    @Override
    public Clinic requestDTOToEntity(ClinicRequestDTO clinicRequestDTO) {
        Clinic clinic = new Clinic();
        clinic.setName(clinicRequestDTO.getName());
        clinic.setAddress(clinicRequestDTO.getAddress());
        clinic.setBankAccountBalance(clinicRequestDTO.getBankAccountBalance());
        clinic.setPhysicians(physicianMapper.dtoListToEntityList(clinicRequestDTO.getPhysicians()));
        clinic.setOperations(operationMapper.dtoListToEntityList(clinicRequestDTO.getOperations()));
        return clinic;
    }

    @Override
    public List<Clinic> requestDTOListToEntityList(List<ClinicRequestDTO> clinicRequestDTOS) {
        List<Clinic> clinics = new ArrayList<>();
        for (ClinicRequestDTO clinicRequestDTO : clinicRequestDTOS) {
            clinics.add(requestDTOToEntity(clinicRequestDTO));
        }
        return clinics;
    }

    @Override
    public Clinic requestDTOToExistEntity(ClinicRequestDTO clinicRequestDTO, Clinic clinic) {
        clinic.setName(clinicRequestDTO.getName());
        clinic.setAddress(clinicRequestDTO.getAddress());
        clinic.setBankAccountBalance(clinicRequestDTO.getBankAccountBalance());
        clinic.setPhysicians(physicianMapper.dtoListToEntityList(clinicRequestDTO.getPhysicians()));
        clinic.setOperations(operationMapper.dtoListToEntityList(clinicRequestDTO.getOperations()));
        return clinic;
    }
}

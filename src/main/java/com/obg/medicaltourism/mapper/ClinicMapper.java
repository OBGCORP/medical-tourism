package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Clinic;
import com.obg.medicaltourism.model.ClinicDTO;
import com.obg.medicaltourism.model.requestDTO.ClinicRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicMapper implements BaseMapper<Clinic, ClinicDTO, ClinicRequestDTO> {
    @Override
    public ClinicDTO entityToDTO(Clinic entity) {
         return null;
    }

    @Override
    public Clinic dtoToEntity(ClinicDTO dto) {
        return null;
    }

    @Override
    public List<ClinicDTO> entityListToDTOList(List<Clinic> clinics) {
        return null;
    }

    @Override
    public List<Clinic> dtoListToEntityList(List<ClinicDTO> clinicDTOS) {
        return null;
    }

    @Override
    public Clinic requestDTOToEntity(ClinicRequestDTO clinicRequestDTO) {
        return null;
    }

    @Override
    public List<Clinic> requestDTOListToEntityList(List<ClinicRequestDTO> clinicRequestDTOS) {
        return null;
    }

    @Override
    public Clinic requestDTOToExistEntity(ClinicRequestDTO clinicRequestDTO, Clinic entity) {
        return null;
    }
}

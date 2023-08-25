package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.model.requestDTO.PhysicianRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhysicianMapper implements BaseMapper<Physician, PhysicianDTO, PhysicianRequestDTO> {
    @Override
    public PhysicianDTO entityToDTO(Physician entity) {
        return null;
    }

    @Override
    public Physician dtoToEntity(PhysicianDTO dto) {
        return null;
    }

    @Override
    public List<PhysicianDTO> entityListToDTOList(List<Physician> physicians) {
        return null;
    }

    @Override
    public List<Physician> dtoListToEntityList(List<PhysicianDTO> physicianDTOS) {
        return null;
    }

    @Override
    public Physician requestDTOToEntity(PhysicianRequestDTO physicianRequestDTO) {
        return null;
    }

    @Override
    public List<Physician> requestDTOListToEntityList(List<PhysicianRequestDTO> physicianRequestDTOS) {
        return null;
    }

    @Override
    public Physician requestDTOToExistEntity(PhysicianRequestDTO physicianRequestDTO, Physician entity) {
        return null;
    }
}

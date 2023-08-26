package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.model.PhysicianDTO;
import com.obg.medicaltourism.model.requestDTO.PhysicianRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhysicianMapper implements BaseMapper<Physician, PhysicianDTO, PhysicianRequestDTO> {
    @Override
    public PhysicianDTO entityToDTO(Physician physician) {
        PhysicianDTO physicianDTO = new PhysicianDTO();
        physicianDTO.setUuid(physician.getUuid());
        physicianDTO.setId(physician.getId());
        physicianDTO.setCreationDate(physician.getCreationDate());
        physicianDTO.setUpdatedDate(physician.getUpdatedDate());
        physicianDTO.setName(physician.getName());
        physicianDTO.setSurname(physician.getSurname());
        physicianDTO.setEmail(physician.getEmail());
        physicianDTO.setPassword(physician.getPassword());
        return physicianDTO;
    }

    @Override
    public Physician dtoToEntity(PhysicianDTO dto) {
        Physician physician = new Physician();
        physician.setUuid(dto.getUuid());
        physician.setId(dto.getId());
        physician.setCreationDate(dto.getCreationDate());
        physician.setUpdatedDate(dto.getUpdatedDate());
        physician.setName(dto.getName());
        physician.setSurname(dto.getSurname());
        physician.setEmail(dto.getEmail());
        physician.setPassword(dto.getPassword());
        return physician;
    }

    @Override
    public List<PhysicianDTO> entityListToDTOList(List<Physician> physicians) {
        List<PhysicianDTO> physicianDTOS = new ArrayList<>();
        for (Physician physician : physicians) {
            physicianDTOS.add(entityToDTO(physician));
        }
        return physicianDTOS;
    }

    @Override
    public List<Physician> dtoListToEntityList(List<PhysicianDTO> physicianDTOS) {
        List<Physician> physicians = new ArrayList<>();
        for (PhysicianDTO physicianDTO : physicianDTOS) {
            physicians.add(dtoToEntity(physicianDTO));
        }
        return physicians;
    }

    @Override
    public Physician requestDTOToEntity(PhysicianRequestDTO physicianRequestDTO) {
        Physician physician = new Physician();
        physician.setName(physicianRequestDTO.getName());
        physician.setSurname(physicianRequestDTO.getSurname());
        physician.setEmail(physicianRequestDTO.getEmail());
        physician.setPassword(physicianRequestDTO.getPassword());
        return physician;
    }

    @Override
    public List<Physician> requestDTOListToEntityList(List<PhysicianRequestDTO> physicianRequestDTOS) {
        List<Physician> physicians = new ArrayList<>();
        for (PhysicianRequestDTO physicianRequestDTO : physicianRequestDTOS) {
            physicians.add(requestDTOToEntity(physicianRequestDTO));
        }
        return physicians;
    }

    @Override
    public Physician requestDTOToExistEntity(PhysicianRequestDTO physicianRequestDTO, Physician physician) {
        physician.setName(physician.getName());
        physician.setSurname(physician.getSurname());
        physician.setEmail(physician.getEmail());
        physician.setPassword(physician.getPassword());
        return physician;
    }
}

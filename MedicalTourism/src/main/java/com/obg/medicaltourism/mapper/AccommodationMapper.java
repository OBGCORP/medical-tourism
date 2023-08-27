package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Accommodation;
import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.requestDTO.AccommodationRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccommodationMapper implements BaseMapper<Accommodation, AccommodationDTO, AccommodationRequestDTO> {
    private final PatientMapper patientMapper;

    @Autowired
    @Lazy
    public AccommodationMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public AccommodationDTO entityToDTO(Accommodation accommodation) {
        AccommodationDTO accommodationDTO = new AccommodationDTO();
        accommodationDTO.setUuid(accommodation.getUuid());
        accommodationDTO.setId(accommodation.getId());
        accommodationDTO.setUpdatedDate(accommodation.getUpdatedDate());
        accommodationDTO.setCreationDate(accommodation.getCreationDate());
        accommodationDTO.setName(accommodation.getName());
        accommodationDTO.setAddress(accommodation.getAddress());
        accommodationDTO.setCost(accommodation.getCost());
        accommodationDTO.setPatient(patientMapper.entityToDTO(accommodation.getPatient()));
        return accommodationDTO;
    }

    @Override
    public Accommodation dtoToEntity(AccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setUuid(dto.getUuid());
        accommodation.setId(dto.getId());
        accommodation.setUpdatedDate(dto.getUpdatedDate());
        accommodation.setCreationDate(dto.getCreationDate());
        accommodation.setName(dto.getName());
        accommodation.setAddress(dto.getAddress());
        accommodation.setCost(dto.getCost());
        if (dto.getPatient() != null) {
            accommodation.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        }
        return accommodation;
    }

    @Override
    public List<AccommodationDTO> entityListToDTOList(List<Accommodation> accommodations) {
        List<AccommodationDTO> accommodationDTOS = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            accommodationDTOS.add(entityToDTO(accommodation));
        }
        return accommodationDTOS;
    }

    @Override
    public List<Accommodation> dtoListToEntityList(List<AccommodationDTO> accommodationDTOS) {
        List<Accommodation> accommodations = new ArrayList<>();
        for (AccommodationDTO accommodationDTO : accommodationDTOS) {
            accommodations.add(dtoToEntity(accommodationDTO));
        }
        return accommodations;
    }

    @Override
    public Accommodation requestDTOToEntity(AccommodationRequestDTO accommodationRequestDTO) {
        Accommodation accommodation = new Accommodation();
        accommodation.setUuid(accommodationRequestDTO.getUuid());
        accommodation.setId(accommodationRequestDTO.getId());
        accommodation.setUpdatedDate(accommodationRequestDTO.getUpdatedDate());
        accommodation.setCreationDate(accommodationRequestDTO.getCreationDate());
        accommodation.setName(accommodationRequestDTO.getName());
        accommodation.setAddress(accommodationRequestDTO.getAddress());
        accommodation.setCost(accommodationRequestDTO.getCost());
        accommodation.setPatient(patientMapper.dtoToEntity(accommodationRequestDTO.getPatient()));
        return accommodation;
    }

    @Override
    public List<Accommodation> requestDTOListToEntityList(List<AccommodationRequestDTO> accommodationRequestDTOS) {
        List<Accommodation> accommodations = new ArrayList<>();
        for (AccommodationRequestDTO accommodationRequestDTO : accommodationRequestDTOS) {
            accommodations.add(requestDTOToEntity(accommodationRequestDTO));
        }
        return accommodations;
    }

    @Override
    public Accommodation requestDTOToExistEntity(AccommodationRequestDTO accommodationRequestDTO, Accommodation accommodation) {
        accommodation.setName(accommodationRequestDTO.getName());
        accommodation.setAddress(accommodationRequestDTO.getAddress());
        accommodation.setCost(accommodationRequestDTO.getCost());
        return accommodation;
    }
}

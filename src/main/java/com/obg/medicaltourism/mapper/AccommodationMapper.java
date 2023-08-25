package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Accommodation;
import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.requestDTO.AccommodationRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccommodationMapper implements BaseMapper<Accommodation, AccommodationDTO, AccommodationRequestDTO> {
    @Override
    public AccommodationDTO entityToDTO(Accommodation entity) {
        return null;
    }

    @Override
    public Accommodation dtoToEntity(AccommodationDTO dto) {
        return null;
    }

    @Override
    public List<AccommodationDTO> entityListToDTOList(List<Accommodation> accommodations) {
        return null;
    }

    @Override
    public List<Accommodation> dtoListToEntityList(List<AccommodationDTO> accommodationDTOS) {
        return null;
    }

    @Override
    public Accommodation requestDTOToEntity(AccommodationRequestDTO accommodationRequestDTO) {
        return null;
    }

    @Override
    public List<Accommodation> requestDTOListToEntityList(List<AccommodationRequestDTO> accommodationRequestDTOS) {
        return null;
    }

    @Override
    public Accommodation requestDTOToExistEntity(AccommodationRequestDTO accommodationRequestDTO, Accommodation entity) {
        return null;
    }
}

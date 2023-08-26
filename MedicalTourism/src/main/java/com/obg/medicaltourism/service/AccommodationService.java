package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Accommodation;
import com.obg.medicaltourism.database.repository.AccommodationRepository;
import com.obg.medicaltourism.mapper.AccommodationMapper;
import com.obg.medicaltourism.model.AccommodationDTO;
import com.obg.medicaltourism.model.requestDTO.AccommodationRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService extends BaseService<Accommodation, AccommodationDTO, AccommodationRequestDTO, AccommodationMapper, AccommodationRepository> {

    private final AccommodationMapper accommodationMapper;
    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationService(AccommodationMapper accommodationMapper, AccommodationRepository accommodationRepository) {
        this.accommodationMapper = accommodationMapper;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public AccommodationMapper getMapper() {
        return accommodationMapper;
    }

    @Override
    public AccommodationRepository getRepository() {
        return accommodationRepository;
    }

    public Page<AccommodationDTO> getAllAccommodationsWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Accommodation> accommodations = accommodationRepository.findAll(PageRequest.of(page, pageSize));
        return accommodations.map(accommodationMapper::entityToDTO);
    }
}

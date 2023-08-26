package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.FlightInfo;
import com.obg.medicaltourism.database.repository.FlightInfoRepository;
import com.obg.medicaltourism.mapper.FlightInfoMapper;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.requestDTO.FlightInfoRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class FlightInfoService extends BaseService<FlightInfo, FlightInfoDTO, FlightInfoRequestDTO, FlightInfoMapper, FlightInfoRepository> {

    private final FlightInfoMapper flightInfoMapper;
    private final FlightInfoRepository flightInfoRepository;

    @Autowired
    public FlightInfoService(FlightInfoMapper flightInfoMapper, FlightInfoRepository flightInfoRepository) {
        this.flightInfoMapper = flightInfoMapper;
        this.flightInfoRepository = flightInfoRepository;
    }

    @Override
    public FlightInfoMapper getMapper() {
        return flightInfoMapper;
    }

    @Override
    public FlightInfoRepository getRepository() {
        return flightInfoRepository;
    }

    public Page<FlightInfoDTO> getAllFlightInfosWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<FlightInfo> flightInfos = flightInfoRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return flightInfos.map(flightInfoMapper::entityToDTO);
    }

}

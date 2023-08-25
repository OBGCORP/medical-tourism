package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.FlightInfo;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.requestDTO.FlightInfoRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightInfoMapper implements BaseMapper<FlightInfo, FlightInfoDTO, FlightInfoRequestDTO> {

    @Override
    public FlightInfoDTO entityToDTO(FlightInfo entity) {
        return null;
    }

    @Override
    public FlightInfo dtoToEntity(FlightInfoDTO dto) {
        return null;
    }

    @Override
    public List<FlightInfoDTO> entityListToDTOList(List<FlightInfo> flightInfos) {
        return null;
    }

    @Override
    public List<FlightInfo> dtoListToEntityList(List<FlightInfoDTO> flightInfoDTOS) {
        return null;
    }

    @Override
    public FlightInfo requestDTOToEntity(FlightInfoRequestDTO flightInfoRequestDTO) {
        return null;
    }

    @Override
    public List<FlightInfo> requestDTOListToEntityList(List<FlightInfoRequestDTO> flightInfoRequestDTOS) {
        return null;
    }

    @Override
    public FlightInfo requestDTOToExistEntity(FlightInfoRequestDTO flightInfoRequestDTO, FlightInfo entity) {
        return null;
    }
}

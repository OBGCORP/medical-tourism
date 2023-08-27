package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.FlightInfo;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.requestDTO.FlightInfoRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightInfoMapper implements BaseMapper<FlightInfo, FlightInfoDTO, FlightInfoRequestDTO> {
    private final PatientMapper patientMapper;

    @Lazy
    public FlightInfoMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public FlightInfoDTO entityToDTO(FlightInfo flightInfo) {
        FlightInfoDTO flightInfoDTO = new FlightInfoDTO();
        flightInfoDTO.setUuid(flightInfo.getUuid());
        flightInfoDTO.setId(flightInfo.getId());
        flightInfoDTO.setCreationDate(flightInfo.getCreationDate());
        flightInfoDTO.setUpdatedDate(flightInfo.getUpdatedDate());
        flightInfoDTO.setAirline(flightInfo.getAirline());
        flightInfoDTO.setFlightNumber(flightInfo.getFlightNumber());
        flightInfoDTO.setDepartureLocation(flightInfo.getDepartureLocation());
        flightInfoDTO.setArrivalLocation(flightInfo.getArrivalLocation());
        flightInfoDTO.setDate(flightInfo.getDate());
        flightInfoDTO.setPrice(flightInfo.getPrice());
        if (flightInfo.getPatient() != null) {
            flightInfoDTO.setPatient(patientMapper.entityToDTO(flightInfo.getPatient()));
        }
        return flightInfoDTO;
    }

    @Override
    public FlightInfo dtoToEntity(FlightInfoDTO dto) {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setUuid(dto.getUuid());
        flightInfo.setId(dto.getId());
        flightInfo.setCreationDate(dto.getCreationDate());
        flightInfo.setUpdatedDate(dto.getUpdatedDate());
        flightInfo.setAirline(dto.getAirline());
        flightInfo.setFlightNumber(dto.getFlightNumber());
        flightInfo.setDepartureLocation(dto.getDepartureLocation());
        flightInfo.setArrivalLocation(dto.getArrivalLocation());
        flightInfo.setDate(dto.getDate());
        flightInfo.setPrice(dto.getPrice());
        if (dto.getPatient() != null) {
            flightInfo.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        }
        return flightInfo;
    }

    @Override
    public List<FlightInfoDTO> entityListToDTOList(List<FlightInfo> flightInfos) {
        List<FlightInfoDTO> flightInfoDTOS = new ArrayList<>();
        for (FlightInfo flightInfo : flightInfos) {
            flightInfoDTOS.add(entityToDTO(flightInfo));
        }
        return flightInfoDTOS;
    }

    @Override
    public List<FlightInfo> dtoListToEntityList(List<FlightInfoDTO> flightInfoDTOS) {
        List<FlightInfo> flightInfos = new ArrayList<>();
        for (FlightInfoDTO flightInfoDTO : flightInfoDTOS) {
            flightInfos.add(dtoToEntity(flightInfoDTO));
        }
        return flightInfos;
    }

    @Override
    public FlightInfo requestDTOToEntity(FlightInfoRequestDTO flightInfoRequestDTO) {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setAirline(flightInfoRequestDTO.getAirline());
        flightInfo.setFlightNumber(flightInfoRequestDTO.getFlightNumber());
        flightInfo.setDepartureLocation(flightInfoRequestDTO.getDepartureLocation());
        flightInfo.setArrivalLocation(flightInfoRequestDTO.getArrivalLocation());
        flightInfo.setDate(flightInfoRequestDTO.getDate());
        flightInfo.setPrice(flightInfoRequestDTO.getPrice());
        if (flightInfoRequestDTO.getPatient() != null) {
            flightInfo.setPatient(patientMapper.dtoToEntity(flightInfoRequestDTO.getPatient()));
        }
        return flightInfo;
    }

    @Override
    public List<FlightInfo> requestDTOListToEntityList(List<FlightInfoRequestDTO> flightInfoRequestDTOS) {
        List<FlightInfo> flightInfos = new ArrayList<>();
        for (FlightInfoRequestDTO flightInfoRequestDTO : flightInfoRequestDTOS) {
            flightInfos.add(requestDTOToEntity(flightInfoRequestDTO));
        }
        return flightInfos;
    }

    @Override
    public FlightInfo requestDTOToExistEntity(FlightInfoRequestDTO flightInfoRequestDTO, FlightInfo flightInfo) {
        flightInfo.setAirline(flightInfoRequestDTO.getAirline());
        flightInfo.setFlightNumber(flightInfoRequestDTO.getFlightNumber());
        flightInfo.setDepartureLocation(flightInfoRequestDTO.getDepartureLocation());
        flightInfo.setArrivalLocation(flightInfoRequestDTO.getArrivalLocation());
        flightInfo.setDate(flightInfoRequestDTO.getDate());
        flightInfo.setPrice(flightInfoRequestDTO.getPrice());
        return flightInfo;
    }
}

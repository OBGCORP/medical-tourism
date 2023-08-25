package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Appointment;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentMapper implements BaseMapper<Appointment, AppointmentDTO, AppointmentRequestDTO> {
    @Override
    public AppointmentDTO entityToDTO(Appointment entity) {
        return null;
    }

    @Override
    public Appointment dtoToEntity(AppointmentDTO dto) {
        return null;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<Appointment> appointments) {
        return null;
    }

    @Override
    public List<Appointment> dtoListToEntityList(List<AppointmentDTO> appointmentDTOS) {
        return null;
    }

    @Override
    public Appointment requestDTOToEntity(AppointmentRequestDTO appointmentRequestDTO) {
        return null;
    }

    @Override
    public List<Appointment> requestDTOListToEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS) {
        return null;
    }

    @Override
    public Appointment requestDTOToExistEntity(AppointmentRequestDTO appointmentRequestDTO, Appointment entity) {
        return null;
    }
}

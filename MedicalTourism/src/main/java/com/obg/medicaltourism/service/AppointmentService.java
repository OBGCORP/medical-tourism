package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Appointment;
import com.obg.medicaltourism.database.repository.AppointmentRepository;
import com.obg.medicaltourism.mapper.AppointmentMapper;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<Appointment, AppointmentDTO, AppointmentRequestDTO, AppointmentMapper, AppointmentRepository> {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    public AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    public Page<AppointmentDTO> getAllAppointmentsWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Appointment> appointments = appointmentRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return appointments.map(appointmentMapper::entityToDTO);
    }

}

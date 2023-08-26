package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Appointment;
import com.obg.medicaltourism.database.repository.AppointmentRepository;
import com.obg.medicaltourism.mapper.AppointmentMapper;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.obg.medicaltourism.service.AppointmentService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController extends BaseController<Appointment, AppointmentDTO, AppointmentRequestDTO, AppointmentMapper, AppointmentRepository, AppointmentService> {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }

}

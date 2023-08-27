package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Appointment;
import com.obg.medicaltourism.model.AppointmentDTO;
import com.obg.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements BaseMapper<Appointment, AppointmentDTO, AppointmentRequestDTO> {
    private final ClinicMapper clinicMapper;
    private final OperationMapper operationMapper;
    private final PhysicianMapper physicianMapper;
    private final PatientMapper patientMapper;

    @Autowired
    @Lazy
    public AppointmentMapper(ClinicMapper clinicMapper, OperationMapper operationMapper, PhysicianMapper physicianMapper, PatientMapper patientMapper) {
        this.clinicMapper = clinicMapper;
        this.operationMapper = operationMapper;
        this.physicianMapper = physicianMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public AppointmentDTO entityToDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setUuid(appointment.getUuid());
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setCreationDate(appointment.getCreationDate());
        appointmentDTO.setUpdatedDate(appointment.getUpdatedDate());
        appointmentDTO.setOperationDate(appointment.getOperationDate());
        if (appointment.getClinic() != null) {
            appointmentDTO.setClinic(clinicMapper.entityToDTO(appointment.getClinic()));
        }
        if (appointment.getOperation() != null) {
            appointmentDTO.setOperation(operationMapper.entityToDTO(appointment.getOperation()));
        }
        if (appointment.getPhysician() != null) {
            appointmentDTO.setPhysician(physicianMapper.entityToDTO(appointment.getPhysician()));
        }
        if (appointment.getPatient() != null) {
            appointmentDTO.setPatient(patientMapper.entityToDTO(appointment.getPatient()));
        }
        return appointmentDTO;
    }

    @Override
    public Appointment dtoToEntity(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setUuid(dto.getUuid());
        appointment.setId(dto.getId());
        appointment.setCreationDate(dto.getCreationDate());
        appointment.setUpdatedDate(dto.getUpdatedDate());
        appointment.setOperationDate(dto.getOperationDate());
        if (dto.getClinic() != null) {
            appointment.setClinic(clinicMapper.dtoToEntity(dto.getClinic()));
        }
        if (dto.getOperation() != null) {
            appointment.setOperation(operationMapper.dtoToEntity(dto.getOperation()));
        }
        if (dto.getPhysician() != null) {
            appointment.setPhysician(physicianMapper.dtoToEntity(dto.getPhysician()));
        }
        if (dto.getPatient() != null) {
            appointment.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        }
        return appointment;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<Appointment> appointments) {
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(entityToDTO(appointment));
        }
        return appointmentDTOS;
    }

    @Override
    public List<Appointment> dtoListToEntityList(List<AppointmentDTO> appointmentDTOS) {
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentDTO appointmentDTO : appointmentDTOS) {
            appointments.add(dtoToEntity(appointmentDTO));
        }
        return appointments;
    }

    @Override
    public Appointment requestDTOToEntity(AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = new Appointment();
        if (appointmentRequestDTO.getClinic() != null) {
            appointment.setClinic(clinicMapper.dtoToEntity(appointmentRequestDTO.getClinic()));
        }
        if (appointmentRequestDTO.getOperation() != null) {
            appointment.setOperation(operationMapper.dtoToEntity(appointmentRequestDTO.getOperation()));
        }
        if (appointmentRequestDTO.getPhysician() != null) {
            appointment.setPhysician(physicianMapper.dtoToEntity(appointmentRequestDTO.getPhysician()));
        }
        if (appointmentRequestDTO.getPatient() != null) {
            appointment.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        }
        appointment.setOperationDate(appointmentRequestDTO.getOperationDate());
        return appointment;
    }

    @Override
    public List<Appointment> requestDTOListToEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS) {
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentRequestDTO appointmentRequestDTO : appointmentRequestDTOS) {
            appointments.add(requestDTOToEntity(appointmentRequestDTO));
        }
        return appointments;
    }

    @Override
    public Appointment requestDTOToExistEntity(AppointmentRequestDTO appointmentRequestDTO, Appointment appointment) {
        if (appointmentRequestDTO.getClinic() != null) {
            appointment.setClinic(clinicMapper.dtoToEntity(appointmentRequestDTO.getClinic()));
        }
        if (appointmentRequestDTO.getOperation() != null) {
            appointment.setOperation(operationMapper.dtoToEntity(appointmentRequestDTO.getOperation()));
        }
        if (appointmentRequestDTO.getPhysician() != null) {
            appointment.setPhysician(physicianMapper.dtoToEntity(appointmentRequestDTO.getPhysician()));
        }
        if (appointmentRequestDTO.getPatient() != null) {
            appointment.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        }
        appointment.setOperationDate(appointmentRequestDTO.getOperationDate());
        return appointment;
    }
}

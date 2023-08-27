package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.database.repository.PatientRepository;
import com.obg.medicaltourism.mapper.PatientMapper;
import com.obg.medicaltourism.model.PatientDTO;
import com.obg.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.obg.medicaltourism.service.PatientService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController extends BaseController<Patient, PatientDTO, PatientRequestDTO, PatientMapper, PatientRepository, PatientService> {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    protected PatientService getService() {
        return patientService;
    }

    @PostMapping("/register")
    public ResponseEntity<PatientDTO> register(PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.register(patientRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<PatientDTO> login(PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.login(patientRequestDTO));
    }

}

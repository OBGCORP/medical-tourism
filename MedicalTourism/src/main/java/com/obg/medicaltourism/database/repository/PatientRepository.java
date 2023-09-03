package com.obg.medicaltourism.database.repository;

import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.utility.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    Optional<Patient> findByEmail(String email);
}

package com.obg.medicaltourism.database.repository;

import com.obg.medicaltourism.database.entity.Clinic;
import com.obg.medicaltourism.database.entity.Physician;
import com.obg.medicaltourism.utility.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicRepository extends BaseRepository<Clinic> {
}

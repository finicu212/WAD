package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}

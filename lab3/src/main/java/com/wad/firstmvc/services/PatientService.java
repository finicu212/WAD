package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.domain.MedicalEncounter;
import com.wad.firstmvc.domain.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    void save(Patient patient);
    List<Patient> findAll();

    // returns all health issues of this patient
    List<HealthIssue> findHealthIssues(Patient patient);
    // returns all patients who had a medical encounter that date
    List<Patient> findByAccidentDate(LocalDate date);
    // returns all his/her patients of careProvider (by name)
    List<Patient> findByCareProvider(String careProviderName);
    // all care providers who performed a health service for given health issue
    List<CareProvider> findByHistory(HealthIssue healthIssue);
}

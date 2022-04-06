package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.domain.Patient;
import com.wad.firstmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public List<HealthIssue> findHealthIssues(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> findByAccidentDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Patient> findByCareProvider(String careProviderName) {
        return null;
    }

    @Override
    public List<CareProvider> findByHistory(HealthIssue healthIssue) {
        return null;
    }
}

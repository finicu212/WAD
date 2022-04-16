package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    void save(Patient patient);
    List<Patient> findAll();


//    // returns all health issues of this patient
//    //@Query("SELECT * FROM HealthIssue hi WHERE hi.patient.name = :patient")
//    List<HealthIssue> findHealthIssuesByPatient(String patient);
//    // returns all patients who had a medical encounter that date
    List<Patient> findPatientsByAccidentDate(LocalDate date);
    // returns all his/her patients of careProvider (by name)
//    List<Patient> findPatientsByCareProvider(String careProviderName);
//    // all care providers who performed a health service for given health issue
//    List<CareProvider> findCareProvidersByHistory(HealthIssue healthIssue);
}

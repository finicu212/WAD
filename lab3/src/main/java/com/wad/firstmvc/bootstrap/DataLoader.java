package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.HealthService;
import com.wad.firstmvc.domain.MedicalEncounter;
import com.wad.firstmvc.domain.Patient;
import com.wad.firstmvc.repositories.HealthServiceRepository;
import com.wad.firstmvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CareProviderService careProviderService;
    @Autowired
    HealthIssueService healthIssueService;
    @Autowired
    HealthServiceService healthServiceService;
    @Autowired
    MedicalEncounterService medicalEncounterService;
    @Autowired
    PatientService patientService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\nSuccess!!\n\n");
        Patient p;
        p = new Patient("Razvan");
        patientService.save(p);
        p = new Patient("Dani");
        patientService.save(p);
        p = new Patient("Andrei");
        patientService.save(p);


        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);
    }
}

package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.HealthService;
import com.wad.firstmvc.domain.MedicalEncounter;
import com.wad.firstmvc.domain.Patient;
import com.wad.firstmvc.services.CareProviderService;
import com.wad.firstmvc.services.HealthServiceService;
import com.wad.firstmvc.services.MedicalEncounterService;
import com.wad.firstmvc.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    PatientService patientService;
    @Autowired
    CareProviderService careProviderService;
    @Autowired
    HealthService healthService;
    @Autowired
    MedicalEncounterService medicalEncounterService;
    @Autowired
    HealthServiceService healthServiceService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\nSuccess!!\n\n");
        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);
    }
}

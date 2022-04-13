package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.*;
import com.wad.firstmvc.repositories.HealthServiceRepository;
import com.wad.firstmvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        Patient razvan = new Patient("Razvan");
        Patient dani = new Patient("Dani");
        Patient andrei = new Patient("Andrei");

        // A baut de la nelu -> s-a dus la relu -> s-a dus la dr. Einstein
        HealthIssue neluBleach = new HealthIssue("drank bleach from nea nelu");
        HealthService reluCloset = new HealthService("recommendation on going to hospital after drinking bleach", "Janitor Closet");
        HealthService bucharestICU = new HealthService("bleach removal", "Intensive Care Unit");
        reluCloset.addHealthIssue(neluBleach);
        bucharestICU.addHealthIssue(neluBleach);
        razvan.addHealthIssue(neluBleach);

        CareProvider relu = new CareProvider("nea Relu", "janitor");
        CareProvider einstein = new CareProvider("dr. Einstein", "terapie intensiva");

        MedicalEncounter razvanEncounter1 = new MedicalEncounter(razvan, LocalDate.parse("2010-10-24"));
        razvanEncounter1.addCareProvider(relu);
        razvanEncounter1.addHealthService(reluCloset);
        MedicalEncounter razvanEncounter2 = new MedicalEncounter(razvan, LocalDate.parse("2011-11-25"));
        razvanEncounter2.addCareProvider(einstein);
        razvanEncounter2.addHealthService(bucharestICU);

        razvan.addMedicalEncounter(razvanEncounter1);
        razvan.addMedicalEncounter(razvanEncounter2);

        MedicalEncounter daniEncounters = new MedicalEncounter(razvan, LocalDate.parse("2014-04-13"));
        MedicalEncounter andreiEncounters = new MedicalEncounter(razvan, LocalDate.parse("2006-01-03"));

//        HealthIssue healthIssue;
//        healthIssue = new HealthIssue("")


        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);
    }
}

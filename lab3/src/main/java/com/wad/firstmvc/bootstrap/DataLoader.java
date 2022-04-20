package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.*;
import com.wad.firstmvc.repositories.PatientRepository;
import com.wad.firstmvc.services.*;
import org.hibernate.TransientPropertyValueException;
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

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Patient Rodica = new Patient("Rodica");

        HealthIssue neluBleach = new HealthIssue("drank bleach from nea nelu");

        HealthService reluCloset = new HealthService("recommendation on going to hospital after drinking bleach", "Janitor Closet");
        HealthService bucharestICU = new HealthService("bleach removal", "Intensive Care Unit");

        CareProvider relu = new CareProvider("nea Relu", "janitor");
        CareProvider einstein = new CareProvider("dr. Einstein", "terapie intensiva");

        MedicalEncounter razvanEncounter1 = new MedicalEncounter(Rodica, LocalDate.parse("2010-10-24"));
        MedicalEncounter razvanEncounter2 = new MedicalEncounter(Rodica, LocalDate.parse("2010-10-25"));

        relu.addMedicalEncounter(razvanEncounter1);
        razvanEncounter1.addHealthService(reluCloset);

        einstein.addMedicalEncounter(razvanEncounter2);
        razvanEncounter2.addHealthService(bucharestICU);

        Rodica.addMedicalEncounter(razvanEncounter1);
        Rodica.addMedicalEncounter(razvanEncounter2);

        neluBleach.addHealthService(reluCloset);
        neluBleach.addHealthService(bucharestICU);

        Rodica.addHealthIssue(neluBleach);

//        MedicalEncounter daniEncounters = new MedicalEncounter(Rodica, LocalDate.parse("2014-04-13"));
//        MedicalEncounter andreiEncounters = new MedicalEncounter(Rodica, LocalDate.parse("2006-01-03"));

//        try {
//            patientService.save(Rodica);
//        } catch (TransientPropertyValueException tpve) {
//            tpve.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("\n");

        System.out.println("All Patients (expected: Rodica)");
        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("all health issues of Rodica:");
        List<HealthIssue> healthIssuesByPatient = healthIssueService.findHealthIssuesByPatientName("Rodica");
        healthIssuesByPatient.forEach(System.out::println);

        System.out.println("\n");

        //List<HealthIssue> issues = patientService.findHealthIssues("Rodica");
        System.out.println("Patients who had an accident on \"2010-10-24\" (expected: Rodica)");
        List<Patient> patientsByDate = patientService.findPatientsByAccidentDate(LocalDate.parse("2010-10-24"));
        patientsByDate.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Patients who had an accident on \"2000-10-24\" (expected: nobody)");
        List<Patient> patientsByWrongDate = patientService.findPatientsByAccidentDate(LocalDate.parse("2000-10-24"));
        patientsByWrongDate.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Patients who had einstein as care provider (expected: Rodica)");
        List<Patient> patientsMetEinstein = patientService.findPatientsByCareProvider("dr. Einstein");
        patientsMetEinstein.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Care providers who had patients who drank bleach from nea nelu");
        List<CareProvider> careProvidersByHealthIssue = careProviderService.findCareProvidersByHistory("drank bleach from nea nelu");
        careProvidersByHealthIssue.forEach(System.out::println);

        System.out.println("\n");


    }
}

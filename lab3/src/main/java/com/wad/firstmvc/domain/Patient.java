package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue
    private long ID;
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Set<MedicalEncounter> encounters = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Set<HealthIssue> healthIssues = new HashSet<>();

    public void addMedicalEncounter(MedicalEncounter medicalEncounter) {
        encounters.add(medicalEncounter);
        medicalEncounter.setPatient(this);
    }

    public void addHealthIssue(HealthIssue healthIssue) {
        healthIssues.add(healthIssue);
        healthIssue.setPatient(this);
    }
}

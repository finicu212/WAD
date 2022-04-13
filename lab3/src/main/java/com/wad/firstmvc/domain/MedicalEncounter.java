package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"careProviders","healthServices"})
@ToString(exclude = {"careProviders","healthServices"})
public class MedicalEncounter {
    @Id
    private long ID;
    private LocalDate date;

    @ManyToOne
    private Patient patient;

    public MedicalEncounter(Patient p, LocalDate localDate) {
        this.date = localDate;
        this.patient = p;
    }

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST)
    private Set<CareProvider> careProviders = new HashSet<>();

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST)
    private Set<HealthService> healthServices = new HashSet<>();

    public void addCareProvider(CareProvider careProvider) {
        this.careProviders.add(careProvider);
        careProvider.setMedicalEncounter(this);
    }

    public void addHealthService(HealthService healthService) {
        this.healthServices.add(healthService);
        healthService.setMedicalEncounter(this);
    }
}

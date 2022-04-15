package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "healthServices")
@ToString(exclude = {"patient","careProvider"})
public class MedicalEncounter {
    @Id
    @GeneratedValue
    private long ID;
    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private CareProvider careProvider;

    public MedicalEncounter(Patient p, LocalDate localDate) {
        this.date = localDate;
        this.patient = p;
    }

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST)
    private Set<HealthService> healthServices = new HashSet<>();

    public void addHealthService(HealthService healthService) {
        this.healthServices.add(healthService);
        healthService.setMedicalEncounter(this);
    }
}

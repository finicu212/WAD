package com.wad.firstmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MedicalEncounter {
    @Id
    private long ID;
    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<CareProvider> careProviders = new HashSet<>();

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<HealthService> healthServices = new HashSet<>();
}

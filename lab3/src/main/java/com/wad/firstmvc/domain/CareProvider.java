package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "medicalEncounters")
public class CareProvider {
    @Id
    private long ID;
    private String name, specialty;

    public CareProvider(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @OneToMany(mappedBy = "careProvider", cascade = CascadeType.PERSIST)
    private Set<MedicalEncounter> medicalEncounters = new HashSet<>();

    public void addMedicalEncounter(MedicalEncounter medicalEncounter) {
        this.medicalEncounters.add(medicalEncounter);
        medicalEncounter.setCareProvider(this);
    }
}

package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "medicalEncounter")
@ToString(exclude = "medicalEncounter")
public class CareProvider {
    @Id
    private long ID;
    private String name, specialty;

    public CareProvider(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @ManyToOne
    private MedicalEncounter medicalEncounter;
}

package com.wad.firstmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
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

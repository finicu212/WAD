package com.wad.firstmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CareProvider {
    @Id
    private long ID;
    private String name, specialty;

    @ManyToOne
    private MedicalEncounter medicalEncounter;
}

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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<MedicalEncounter> encounters = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<HealthIssue> healthIssues = new HashSet<>();
}

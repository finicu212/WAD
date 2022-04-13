package com.wad.firstmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HealthService {
    @Id
    private long ID;
    private String description, type;

    public HealthService(String description, String type) {
        this.description = description;
        this.type = type;
    }

    @OneToMany(mappedBy = "healthService", cascade = CascadeType.PERSIST)
    private Set<HealthIssue> healthIssues = new HashSet<>();

    public void addHealthIssue(HealthIssue healthIssue) {
        this.getHealthIssues().add(healthIssue);
        healthIssue.setHealthService(this);
    }

    @ManyToOne
    private MedicalEncounter medicalEncounter;
}

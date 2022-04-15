package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"healthIssue","medicalEncounter"})
public class HealthService {
    @Id
    @GeneratedValue
    private long ID;
    private String description, type;

    public HealthService(String description, String type) {
        this.description = description;
        this.type = type;
    }

    @ManyToOne
    private HealthIssue healthIssue;

    @ManyToOne
    private MedicalEncounter medicalEncounter;
}

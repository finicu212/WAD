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

    @OneToMany(mappedBy = "healthService", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<HealthIssue> healthIssues = new HashSet<>();

    @ManyToOne
    private MedicalEncounter medicalEncounter;
}

package com.wad.firstmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HealthIssue {
    @Id
    private long ID;
    private String type;

    public HealthIssue(String type) {
        this.type = type;
    }

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private HealthService healthService;
}

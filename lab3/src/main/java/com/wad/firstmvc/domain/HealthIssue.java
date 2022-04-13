package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"patient","healthService"})
@ToString(exclude = {"patient","healthService"})
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

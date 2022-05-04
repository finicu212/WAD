package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "vehicle")
@EqualsAndHashCode(exclude = "maintenanceItems")
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private String name, location;
    private float workPrice;
    private Date date;
    @OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<MaintenanceItem> maintenanceItems = new HashSet<>();
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Vehicle vehicle;

    public Appointment(String name, String location, float workPrice, Date date) {
        this.name = name;
        this.location = location;
        this.workPrice = workPrice;
        this.date = date;
    }

    public void addMaintenanceItem(MaintenanceItem maintenanceItem) {
        this.maintenanceItems.add(maintenanceItem);
    }
}

package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String name, location;
    private float workPrice;
    private Date date;
    @OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER)
    private Set<MaintenanceItem> maintenanceItems = new HashSet<>();
    @ManyToOne
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

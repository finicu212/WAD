package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue
    private int id;
    private String make, model;
//    private Driver driver;
//    private FuelType fueltype;
    private float engineCapacity;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private Set<MaintenanceItem> maintenanceItems = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private Set<Appointment> appointments = new HashSet<>();

    public Vehicle(String make, String model, float engineCapacity) {
        this.make = make;
        this.model = model;
        this.engineCapacity = engineCapacity;
    }

    public void addMaintenanceItem(MaintenanceItem maintenanceItem) {
        this.maintenanceItems.add(maintenanceItem);
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}

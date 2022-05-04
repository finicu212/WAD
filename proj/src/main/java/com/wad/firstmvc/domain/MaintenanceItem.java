package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class MaintenanceItem {
    @Id
    @GeneratedValue
    private int id;
    private String name, description, provider;
    private float price;

    @ManyToOne
    private Appointment appointment;
    @ManyToOne
    private Vehicle vehicle;

    public MaintenanceItem(String name, String description, String provider, float price) {
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.price = price;
    }
}

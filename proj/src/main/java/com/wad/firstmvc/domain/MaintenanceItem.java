package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"appointment", "vehicle"})
public class MaintenanceItem {
    @Id
    @GeneratedValue
    private Long id;
    private String name, description, provider;
    private float price;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Appointment appointment;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Vehicle vehicle;

    public MaintenanceItem(String name, String description, String provider, float price) {
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.price = price;
    }
}

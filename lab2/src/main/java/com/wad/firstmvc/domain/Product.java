package com.wad.firstmvc.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private Long id;
    private float price;
    private String name, category;

    public String getCategory() {
        return category;
    }
    public float getPrice() {
        return price;
    }
}

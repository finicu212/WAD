package com.example.mvcproducts.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private Set<Product> products = new HashSet<Product>();

    public void addProduct(Product p) {
        products.add(p);
    }
}

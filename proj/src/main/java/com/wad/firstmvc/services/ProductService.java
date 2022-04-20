package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findProducts(String category);
    List<Product> findProducts(String category, float minPrice, float maxPrice);
    void save(Product p);
}

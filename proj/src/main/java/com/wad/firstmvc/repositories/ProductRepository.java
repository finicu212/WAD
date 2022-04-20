package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select p from Product p where p.category = :category")
    List<Product> findProducts(String category);
    @Query("select p from Product p where p.category = :category and p.price > :minPrice and p.price < :maxPrice")
    List<Product> findProducts(String category, float minPrice, float maxPrice);
}

package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void saveAll(Iterable<Product> products) {
    productRepository.saveAll(products);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }

  @Override
  public Product findById(Long pid) {
    Optional<Product> result = productRepository.findById(pid);
//    return result.get();
    return result.orElse(null);
  }
}

package org.example.lab5.services.impl;

import org.example.lab5.models.Product;
import org.example.lab5.repositories.ProductRepository;
import org.example.lab5.services.Iservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements Iservices<Product,Long> {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean save(Product entity) {
       try {
              productRepository.save(entity);
              return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(String.valueOf(id));
        return true;
    }

    @Override
    public boolean update(Product entity) {
        return productRepository.save(entity) != null;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


}

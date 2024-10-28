package com.javacourse.section22.section22.webservice.services;

import com.javacourse.section22.section22.webservice.entities.Product;
import com.javacourse.section22.section22.webservice.repositories.ProductRepository;
import com.javacourse.section22.section22.webservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}

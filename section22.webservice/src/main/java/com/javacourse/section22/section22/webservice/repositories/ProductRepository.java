package com.javacourse.section22.section22.webservice.repositories;

import com.javacourse.section22.section22.webservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

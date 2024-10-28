package com.javacourse.section22.section22.webservice.repositories;

import com.javacourse.section22.section22.webservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

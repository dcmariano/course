package com.javacourse.section22.section22.webservice.services;

import com.javacourse.section22.section22.webservice.entities.Category;
import com.javacourse.section22.section22.webservice.repositories.CategoryRepository;
import com.javacourse.section22.section22.webservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}

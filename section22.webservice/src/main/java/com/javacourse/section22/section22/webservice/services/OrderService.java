package com.javacourse.section22.section22.webservice.services;

import com.javacourse.section22.section22.webservice.entities.Order;
import com.javacourse.section22.section22.webservice.repositories.OrderRepository;
import com.javacourse.section22.section22.webservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}

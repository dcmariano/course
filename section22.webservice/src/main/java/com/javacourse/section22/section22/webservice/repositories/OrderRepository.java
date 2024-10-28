package com.javacourse.section22.section22.webservice.repositories;

import com.javacourse.section22.section22.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

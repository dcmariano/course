package com.javacourse.section22.section22.webservice.repositories;

import com.javacourse.section22.section22.webservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

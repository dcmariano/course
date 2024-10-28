package com.javacourse.section22.section22.webservice.repositories;

import com.javacourse.section22.section22.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

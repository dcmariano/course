package com.javacourse.workshopmongo.repositories;

import com.javacourse.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

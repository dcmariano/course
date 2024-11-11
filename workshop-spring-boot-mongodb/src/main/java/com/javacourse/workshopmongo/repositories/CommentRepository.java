package com.javacourse.workshopmongo.repositories;

import com.javacourse.workshopmongo.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

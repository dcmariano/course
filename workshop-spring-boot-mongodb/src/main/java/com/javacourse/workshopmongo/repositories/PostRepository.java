package com.javacourse.workshopmongo.repositories;

import com.javacourse.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0 , $options: 'i'} }")
    List<Post> searchTitle(String text);

    @Query("{ $and: [ { createAt: { $gte: ?1 } }, { createAt: { $lte: ?2 } }, { $or: [ { title: { $regex: ?0, $options: 'i' } }, { body: { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Instant min, Instant max);
}

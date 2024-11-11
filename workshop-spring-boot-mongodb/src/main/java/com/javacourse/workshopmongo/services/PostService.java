package com.javacourse.workshopmongo.services;

import com.javacourse.workshopmongo.domain.Comment;
import com.javacourse.workshopmongo.domain.Post;
import com.javacourse.workshopmongo.domain.User;
import com.javacourse.workshopmongo.dto.CommentDTO;
import com.javacourse.workshopmongo.dto.PostDTO;
import com.javacourse.workshopmongo.repositories.PostRepository;
import com.javacourse.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post id " + id + " not found"));
    }

    public Post insert(Post post) {
        if (post.getId() != null && repository.existsById(post.getId()))
            throw new DataIntegrityViolationException("Post id " + post.getId() + " exists");
        return repository.insert(post);
    }

    public void deleteById(String id) {
        if (!repository.existsById(id)) throw new ObjectNotFoundException("Post id " + id + " not found");
        repository.deleteById(id);
    }

    public Post update(String id, Post updatedPost) {
        Post existingPost = findById(id);
        updateData(existingPost, updatedPost);
        return repository.save(existingPost);
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Instant min, Instant max) {
        LocalDate minDate = min.atZone(ZoneOffset.UTC).toLocalDate();
        Instant startOfDay = minDate.atStartOfDay(ZoneOffset.UTC).toInstant();

        LocalDate maxDate = max.atZone(ZoneOffset.UTC).toLocalDate();
        Instant endOfDay = maxDate.atTime(23, 59, 59, 999_999_999).atZone(ZoneOffset.UTC).toInstant();

        return repository.fullSearch(text, startOfDay, endOfDay);
    }

    private void updateData(Post existingPost, Post updatedPost) {
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBody(updatedPost.getBody());
        existingPost.setAuthor(updatedPost.getAuthor());
        existingPost.setComments(updatedPost.getComments());
    }

    public static Post fromDTO(PostDTO postDto) {
        User user = new User();
        user.setId(postDto.author().id());
        user.setName(postDto.author().name());

        Post post = new Post(
                postDto.id(),
                postDto.title(),
                postDto.body(),
                user
        );

        List<Comment> comments = postDto.comments().stream()
                .map(PostService::convertToComment)
                .collect(Collectors.toList());

        post.setComments(comments);

        return post;
    }

    private static Comment convertToComment(CommentDTO commentDTO) {
        return new Comment(
                commentDTO.id(),
                commentDTO.text(),
                new User(commentDTO.author().id(), commentDTO.author().name(), null),
                commentDTO.postId()
        );
    }
}

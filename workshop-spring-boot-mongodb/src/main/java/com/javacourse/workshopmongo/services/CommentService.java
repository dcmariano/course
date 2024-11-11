package com.javacourse.workshopmongo.services;

import com.javacourse.workshopmongo.domain.Comment;
import com.javacourse.workshopmongo.domain.User;
import com.javacourse.workshopmongo.dto.CommentDTO;
import com.javacourse.workshopmongo.repositories.CommentRepository;
import com.javacourse.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Buscar todos os comentários
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Comment not found"));
    }

    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment update(String id, Comment comment) {
        findById(id);
        comment.setId(id);
        return commentRepository.save(comment);
    }

    public void deleteById(String id) {
        findById(id);
        commentRepository.deleteById(id);
    }

    public static Comment fromDTO(CommentDTO commentDto) {
        return new Comment(
                commentDto.id(),
                commentDto.text(),
                new User(commentDto.author().id(),  commentDto.author().name(), null),
                commentDto.postId()
        );
    }
}


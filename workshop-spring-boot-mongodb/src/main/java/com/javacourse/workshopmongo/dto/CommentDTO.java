package com.javacourse.workshopmongo.dto;

import com.javacourse.workshopmongo.domain.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

public record CommentDTO(
        String id,
        Instant createAt,
        String text,
        AuthorDTO author,
        String postId
) implements Serializable {

    private static final long serialVersionUID = 1L;

    public CommentDTO(Comment comment) {
        this(
                comment.getId(),
                comment.getCreateAt(),
                comment.getText(),
                new AuthorDTO(comment.getAuthor()),
                comment.getPostId()
        );
    }
}

package com.javacourse.workshopmongo.dto;

import com.javacourse.workshopmongo.domain.Post;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public record PostDTO(
        String id,
        Instant createAt,
        String title,
        String body,
        AuthorDTO author,
        List<CommentDTO> comments
) implements Serializable {

    private static final long serialVersionUID = 1L;

    public PostDTO(Post post) {
        this(
                post.getId(),
                post.getCreateAt(),
                post.getTitle(),
                post.getBody(),
                new AuthorDTO(post.getAuthor()),
                post.getComments().stream()
                        .map(CommentDTO::new)
                        .collect(Collectors.toList())
        );
    }
}

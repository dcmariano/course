package com.javacourse.workshopmongo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "comments")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @CreatedDate
    private Instant createAt;
    private String text;

    @DBRef(lazy = true)
    private User author;

    private String postId;

    @LastModifiedDate
    private Instant updateAt;

    public Comment(String id, String text, User author, String postId) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.postId = postId;
    }
}

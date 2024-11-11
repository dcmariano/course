package com.javacourse.workshopmongo.dto;

import com.javacourse.workshopmongo.domain.User;

import java.io.Serializable;

public record AuthorDTO(String id, String name) implements Serializable {

    private static final long serialVersionUID = 1L;

    public AuthorDTO(User obj) {
        this(obj.getId(), obj.getName());
    }
}

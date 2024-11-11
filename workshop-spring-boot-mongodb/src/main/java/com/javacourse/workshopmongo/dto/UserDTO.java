package com.javacourse.workshopmongo.dto;

import com.javacourse.workshopmongo.domain.User;

public record UserDTO(String id, String name, String email) {

    public User toEntity() {
        return new User(this.id, this.name, this.email);
    }

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}

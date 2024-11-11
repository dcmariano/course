package com.javacourse.workshopmongo.services;

import com.javacourse.workshopmongo.domain.User;
import com.javacourse.workshopmongo.dto.UserDTO;
import com.javacourse.workshopmongo.repositories.UserRepository;
import com.javacourse.workshopmongo.services.exceptions.ObjectAlreadyExists;
import com.javacourse.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User id " + id + " not found"));
    }

    public User insert(User user) {
        if (user.getId() != null && repository.existsById(user.getId())) {
            throw new ObjectAlreadyExists("User id " + user.getId() + " already exists");
        }
        return repository.insert(user);
    }

    public void deleteById(String id) {
        if (!repository.existsById(id)) throw new ObjectNotFoundException("User id " + id + " not found");
        repository.deleteById(id);
    }

    public User update(String id, User updatedUser) {
        User existingUser = findById(id);
        updateData(existingUser, updatedUser);
        return repository.save(existingUser);
    }

    private void updateData(User existingUser, User updatedUser) {
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
    }

    public static User fromDTO(UserDTO userDto) {
        return new User(userDto.id(), userDto.name(), userDto.name());
    }
}

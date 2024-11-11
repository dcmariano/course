package com.javacourse.workshopmongo.resources;

import com.javacourse.workshopmongo.domain.Post;
import com.javacourse.workshopmongo.domain.User;
import com.javacourse.workshopmongo.dto.UserDTO;
import com.javacourse.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAll().stream().map(UserDTO::new).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(new UserDTO(userService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDto) {
        User user = userService.insert(UserService.fromDTO(userDto));
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getId())
                        .toUri())
                .body(new UserDTO(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDto, @PathVariable String id) {
        User user = userService.update(id, UserService.fromDTO(userDto));
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id).getPosts());
    }
}

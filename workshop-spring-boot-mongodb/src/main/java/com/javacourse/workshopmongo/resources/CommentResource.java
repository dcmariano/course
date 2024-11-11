package com.javacourse.workshopmongo.resources;

import com.javacourse.workshopmongo.domain.Comment;
import com.javacourse.workshopmongo.dto.CommentDTO;
import com.javacourse.workshopmongo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> findAll() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok().body(comments.stream().map(CommentDTO::new).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok(new CommentDTO(comment));
    }

    @PostMapping
    public ResponseEntity<CommentDTO> insert(@RequestBody CommentDTO commentDto) {
        Comment comment = commentService.insert(CommentService.fromDTO(commentDto));
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(comment.getId())
                        .toUri())
                .body(new CommentDTO(comment));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> update(@RequestBody CommentDTO commentDto, @PathVariable String id) {
        Comment comment = commentService.update(id, CommentService.fromDTO(commentDto));
        return ResponseEntity.ok(new CommentDTO(comment));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

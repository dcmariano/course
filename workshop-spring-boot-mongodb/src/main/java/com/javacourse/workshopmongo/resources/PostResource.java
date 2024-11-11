package com.javacourse.workshopmongo.resources;

import com.javacourse.workshopmongo.domain.Post;
import com.javacourse.workshopmongo.dto.PostDTO;
import com.javacourse.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        return ResponseEntity.ok().body(postService.findAll().stream().map(PostDTO::new).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(new PostDTO(postService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PostDTO> insert(@RequestBody PostDTO postDto) {
        Post post = postService.insert(PostService.fromDTO(postDto));
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(post.getId())
                        .toUri())
                .body(new PostDTO(post));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDTO> deleteById(@PathVariable String id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDto, @PathVariable String id) {
        Post post = postService.update(id, PostService.fromDTO(postDto));
        return ResponseEntity.ok(new PostDTO(post));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        String decodedText = URLDecoder.decode(text, StandardCharsets.UTF_8);
        List<PostDTO> postDTOs = postService.findByTitle(decodedText)
                .stream()
                .map(PostDTO::new)
                .toList();
        return ResponseEntity.ok(postDTOs);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        String decodedText = URLDecoder.decode(text, StandardCharsets.UTF_8);

        LocalDate minLocalDate = null;
        LocalDate maxLocalDate = null;

        try {
            minLocalDate = LocalDate.parse(minDate);
            maxLocalDate = LocalDate.parse(maxDate);
        } catch (DateTimeParseException e) {
            throw e;
        }

        // Convert to Instant and call service
        Instant minInstant = minLocalDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant maxInstant = maxLocalDate.atStartOfDay().toInstant(ZoneOffset.UTC);

        List<PostDTO> postDTOs = postService.fullSearch(decodedText, minInstant, maxInstant)
                .stream()
                .map(PostDTO::new)
                .toList();

        return ResponseEntity.ok(postDTOs);
    }

}

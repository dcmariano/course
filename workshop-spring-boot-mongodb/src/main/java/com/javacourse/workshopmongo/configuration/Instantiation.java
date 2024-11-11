package com.javacourse.workshopmongo.configuration;

import com.javacourse.workshopmongo.domain.Comment;
import com.javacourse.workshopmongo.domain.Post;
import com.javacourse.workshopmongo.domain.User;
import com.javacourse.workshopmongo.repositories.CommentRepository;
import com.javacourse.workshopmongo.repositories.PostRepository;
import com.javacourse.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        commentRepository.deleteAll();

        User user1 = new User(null, "Alice", "alice@example.com");
        User user2 = new User(null, "Bob", "bob@example.com");
        User user3 = new User(null, "Charlie", "charlie@example.com");
        User user4 = new User(null, "Diana", "diana@example.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        Post post1 = new Post(null, "First Post", "This is the body of the first post", user1);
        Post post2 = new Post(null, "Second Post", "This is the body of the second post", user2);
        Post post3 = new Post(null, "Third Post", "This is the body of the third post", user3);
        Post post4 = new Post(null, "Fourth Post", "This is the body of the fourth post", user4);
        Post post5 = new Post(null, "Fifth Post", "This is the body of the fifth post", user1);

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5));

        Comment comment1 = new Comment(null, "Great post, Alice!", user2, post1.getId());
        Comment comment2 = new Comment(null, "I agree with you, Bob!", user1, post2.getId());
        Comment comment3 = new Comment(null, "Interesting perspective, Charlie.", user4, post3.getId());
        Comment comment4 = new Comment(null, "Nice write-up, Diana.", user3, post4.getId());
        Comment comment5 = new Comment(null, "I really liked your thoughts on this, Alice.", user2, post5.getId());

        commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4, comment5));

        user1.getPosts().add(post1);
        user1.getPosts().add(post5);
        user2.getPosts().add(post2);
        user3.getPosts().add(post3);
        user4.getPosts().add(post4);

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        post1.getComments().add(comment1);
        post2.getComments().add(comment2);
        post3.getComments().add(comment3);
        post4.getComments().add(comment4);
        post5.getComments().add(comment5);

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5));
    }
}

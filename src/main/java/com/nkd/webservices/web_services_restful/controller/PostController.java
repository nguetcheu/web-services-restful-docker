package com.nkd.webservices.web_services_restful.controller;

import com.nkd.webservices.web_services_restful.entity.Post;
import com.nkd.webservices.web_services_restful.entity.User;
import com.nkd.webservices.web_services_restful.service.PostService;
import com.nkd.webservices.web_services_restful.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Post")
public class PostController {

    private final PostService postService;

    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("all")
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{postId}")
    private ResponseEntity<Optional<Post>> getPostById(@PathVariable("postId") Long postId) {
        Optional<Post> optionalPost = postService.getPostById(postId);
        return new ResponseEntity<>(optionalPost, HttpStatus.OK);
    }

    @PostMapping("save/{userId}")
    private ResponseEntity<Post> savePost(@RequestBody Post post, @PathVariable("userId") Long userId){

        Optional<User> userOptional = userService.getUserById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }
        Post createdPost = postService.createPost(userId,post);
        return ResponseEntity.ok(createdPost);
    }

    @DeleteMapping("delete/{postId}")
    private String deletePostById(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return "Post why id " + postId + "was deleted";
    }
}

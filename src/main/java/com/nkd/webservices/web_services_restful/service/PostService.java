package com.nkd.webservices.web_services_restful.service;

import com.nkd.webservices.web_services_restful.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();

    Post createPost(Long userId, Post post);

    Optional<Post> getPostById(Long id);

    void deletePost(Long id);

}

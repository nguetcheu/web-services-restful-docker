package com.nkd.webservices.web_services_restful.service;

import com.nkd.webservices.web_services_restful.entity.Post;
import com.nkd.webservices.web_services_restful.entity.User;
import com.nkd.webservices.web_services_restful.repository.PostRepository;
import com.nkd.webservices.web_services_restful.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Long userId, Post post) {

        User user = userRepository.getReferenceById(userId);

        post.setUser(user);

        postRepository.save(post);

        return post;
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        Optional<Post> optionalPost = Optional.ofNullable(postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post with id " + id)));
        return optionalPost;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

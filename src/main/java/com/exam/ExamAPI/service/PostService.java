package com.exam.ExamAPI.service;

import com.exam.ExamAPI.contoller.handler.ResourceNotFoundException;
import com.exam.ExamAPI.domain.Post;
import com.exam.ExamAPI.repository.PostRepository;
import com.exam.ExamAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void verifyPost(Long postId) throws ResourceNotFoundException{
        Post p = postRepository.findById(postId).orElse(null);
        if(p == null){
            throw new ResourceNotFoundException("Post with id" + postId + "could not be found");
        }
    }
    public ResponseEntity<?> createPost(Post post){
        post = postRepository.save(post);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}

package com.exam.ExamAPI.service;

import com.exam.ExamAPI.contoller.handler.ResourceNotFoundException;
import com.exam.ExamAPI.domain.User;
import com.exam.ExamAPI.repository.PostRepository;
import com.exam.ExamAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void verifyUser(Long userId) throws ResourceNotFoundException {
        User u = userRepository.findById(userId).orElse(null);
        if(u == null){
            throw new ResourceNotFoundException("User with id" + userId + "Could not be found");
        }
    }

    public ResponseEntity<?> createUser(User user){
        user = userRepository.save(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

//    public ResponseEntity<?> getUserById(Long userId){
//        return userRepository.findById(userId);
//    }

    public ResponseEntity<?> updateUser(Long id, User user){
        verifyUser(id);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteUserById(Long id){
        verifyUser(id);
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

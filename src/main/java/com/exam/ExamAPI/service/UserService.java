package com.exam.ExamAPI.service;

import com.exam.ExamAPI.contoller.handler.ResourceNotFoundException;
import com.exam.ExamAPI.domain.User;
import com.exam.ExamAPI.repository.CommentRepository;
import com.exam.ExamAPI.repository.PostRepository;
import com.exam.ExamAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public void verifyUser(Long userId) throws ResourceNotFoundException {
        User u = userRepository.findById(userId).orElse(null);
        if(u == null){
            throw new ResourceNotFoundException("User with id" + userId + "Could not be found");
        }
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(User user, long userId){
        verifyUser(userId);
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

}

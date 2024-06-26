package com.exam.ExamAPI.service;

import com.exam.ExamAPI.contoller.handler.ResourceNotFoundException;
import com.exam.ExamAPI.domain.Comment;
import com.exam.ExamAPI.domain.Post;
import com.exam.ExamAPI.repository.CommentRepository;
import com.exam.ExamAPI.repository.PostRepository;
import com.exam.ExamAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public void verifyPost(Long postId) throws ResourceNotFoundException{
        Post p = postRepository.findById(postId).orElse(null);
        if(p == null){
            throw new ResourceNotFoundException("Post with id" + postId + "could not be found");
        }
    }
    public Post createPost(Post post){

        return postRepository.save(post);
    }

    public Post getPostById(long postId){
        return postRepository.findById(postId).orElse(null);
    }

    public List<Post> getPostsByUserId(long userId){
        return postRepository.findByUserId(userId);
    }

    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void deletePost(long postId){
        verifyPost(postId);
        postRepository.deleteById(postId);
    }

    public Post updatePost(Post post, long postId){
        verifyPost(postId);
        return postRepository.save(post);
    }


    public Comment createComment(Long postId, Comment comment) {
        Post post = getPostById(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(null);
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Iterable<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void deleteComment(Long commentId) {
        Comment comment = getCommentById(commentId);
        commentRepository.delete(comment);
    }

    public Comment updateComment(Comment comment, long commentId) {
        Comment c = commentRepository.findById(commentId).orElse(null);
        if(c == null){
            throw new ResourceNotFoundException("Comment with id" + commentId + "could not be found");
        }
        return commentRepository.save(comment);
    }
}

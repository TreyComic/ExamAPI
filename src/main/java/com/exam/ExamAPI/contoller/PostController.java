package com.exam.ExamAPI.contoller;

import com.exam.ExamAPI.domain.Comment;
import com.exam.ExamAPI.domain.Post;
import com.exam.ExamAPI.service.PostService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @GetMapping("/posts/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(post, id);
    }

    // Comment-related endpoints
    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return postService.createComment(postId, comment);
    }

    @GetMapping("/posts/{postId}/comments")
    public Iterable<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return postService.getCommentsByPostId(postId);
    }

    @GetMapping("/comments/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return postService.getCommentById(commentId);
    }

    @GetMapping("/comments")
    public Iterable<Comment> getAllComments() {
        return postService.getAllComments();
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        postService.deleteComment(commentId);
    }

    @PutMapping("/comments/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        return postService.updateComment(comment, commentId);
    }
}

package com.exam.ExamAPI.repository;

import com.exam.ExamAPI.domain.Comment;
import com.exam.ExamAPI.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}

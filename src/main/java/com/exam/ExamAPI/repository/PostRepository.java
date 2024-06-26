package com.exam.ExamAPI.repository;
import com.exam.ExamAPI.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByUserId(long userId);
}

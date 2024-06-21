package com.exam.ExamAPI.repository;
import com.exam.ExamAPI.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}

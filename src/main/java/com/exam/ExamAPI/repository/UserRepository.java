package com.exam.ExamAPI.repository;
import com.exam.ExamAPI.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

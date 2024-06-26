package com.exam.ExamAPI.domain;

import com.exam.ExamAPI.repository.PostRepository;
import com.exam.ExamAPI.repository.UserRepository;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;
import java.util.SplittableRandom;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "contentsOfPost")
    private String content;

    private long userId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "POST_ID")
//    private Set<Comment> comments;

    public Post(int id, String title, String content, long userId) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Post() {

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }
}

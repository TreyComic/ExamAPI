package com.exam.ExamAPI.domain;

import com.exam.ExamAPI.domain.enums.Gender;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "gender")
    private Gender gender;

    public User(int id, String username, Gender gender) {

        this.id = id;
        this.username = username;
        this.gender = gender;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

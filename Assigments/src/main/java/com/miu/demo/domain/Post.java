package com.miu.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String content;
    String author;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // ✅ Гадны түлхүүрийг заана
    @JsonBackReference
    private User user;

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Post() {}
    public Post(int id, String name, String content, String author,User user ) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.user = user;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}

package com.miu.demo.domain;


import java.time.LocalDateTime;
import java.util.List;
public class Post {
    long id;
    String name;
    String content;
    String author;
    public Post() {}
    public Post(long id, String name, String content, String author) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
    }

    public void setId(long id) {
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

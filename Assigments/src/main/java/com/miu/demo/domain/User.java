package com.miu.demo.domain;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    public User(){}
    public User(int id, List<Post> postList, String name) {
        this.id = id;
        this.postList = postList;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPostList() {
        return postList;
    }
    String name;
    @OneToMany
    @JoinColumn(name = "user_id")  // This creates a foreign key column 'user_id' in the Post table


    List<Post> postList;

}

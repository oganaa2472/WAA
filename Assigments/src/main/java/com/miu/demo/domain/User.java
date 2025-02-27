package com.miu.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
//@Table(name = "PostUser")
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
    @OneToMany(mappedBy = "user")
    List<Post> postList;

}

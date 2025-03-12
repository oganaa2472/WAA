package com.miu.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table

@Data
@NoArgsConstructor
@Table(name = "posts")
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String content;
    String author;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private List<Comment> comments;



}

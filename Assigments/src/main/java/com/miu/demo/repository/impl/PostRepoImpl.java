package com.miu.demo.repository.impl;

import com.miu.demo.domain.Post;
import com.miu.demo.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 11;
    static {
        posts = new ArrayList<>();
        posts = generateInitialPosts();
    }

    static List<Post> generateInitialPosts() {
        List<Post> initialPosts = new ArrayList<>();
        initialPosts.add(new Post(1, "The Power of Habit", "An exploration of habits and their impact on our lives.", "Charles Duhigg"));
        initialPosts.add(new Post(2, "Atomic Habits", "A guide to building good habits and breaking bad ones.", "James Clear"));
        initialPosts.add(new Post(3, "Deep Work", "How to focus and produce high-quality work.", "Cal Newport"));
        initialPosts.add(new Post(4, "The Lean Startup", "Entrepreneurial strategies for building successful startups.", "Eric Ries"));
        initialPosts.add(new Post(5, "Thinking, Fast and Slow", "A deep dive into human decision-making.", "Daniel Kahneman"));
        initialPosts.add(new Post(6, "Grit", "The power of passion and perseverance.", "Angela Duckworth"));
        initialPosts.add(new Post(7, "Zero to One", "Insights into building a successful startup.", "Peter Thiel"));
        initialPosts.add(new Post(8, "The 4-Hour Workweek", "How to escape the 9-5 grind and build passive income.", "Tim Ferriss"));
        initialPosts.add(new Post(9, "Hooked", "Understanding what makes products habit-forming.", "Nir Eyal"));
        initialPosts.add(new Post(10, "The Psychology of Money", "Timeless lessons on wealth, greed, and happiness.", "Morgan Housel"));
        return initialPosts;
    }
    public List<Post> findAll(){
        return posts;
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return posts.stream().filter(p -> p.getAuthor().equals(author)).collect(Collectors.toList());
    }
    @Override
    public List<Post> searchPostsByAuthor(String text) {
        return posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void save(Post p) {
        p.setId (postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(p);
    }
    @Override
    public void delete(int id) {
        var product = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(product);
    }
    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setName(p.getName());
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setContent(p.getContent());
    }
    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }
}

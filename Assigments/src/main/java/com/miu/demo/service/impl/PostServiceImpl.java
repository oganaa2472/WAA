package com.miu.demo.service.impl;


import com.miu.demo.domain.Post;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> searchByTitle(String title) {
        return postRepo.searchByTitle(title);
    }

    //    public List<Post> searchByTitle(String title) {
//        return postRepo.findByTitleContaining(title);
//    }

    @Transactional
    public List<Post> findAll() {
        return postRepo.findAll();
    }
    public Optional<Post> getById(int id) {
        return postRepo.findById(id);
    }
    public void save(Post post) {
         postRepo.save(post);
    }

    public void delete(int id) {
        postRepo.deleteById(id);
    }


//    @Override
//    public void update(int id, Post post) {
//
//    }
    //    @Autowired
//    private final PostRepo postRepo;
//
//    @Autowired
//    ModelMapper modelMapper;
//    @Autowired
//    ListMapper listMapper;
//
//    public List<PostDto> findAll() {
//        return listMapper.mapList(postRepo.findAll(),new PostDto());
//    }
//    @Override
//    public PostDto getById(int id) {
//        return modelMapper.map(postRepo.getById(id),PostDto.class);
//    }
//
//    @Override
//    public void save(Post post) {
//
//         postRepo.save(modelMapper.map(post,Post.class));
//    }
//
//    @Override
//    public void delete(int id) {
//        postRepo.deleteById(id);
//    }

//    @Override
//    public void update(int id, PostDto postDto) {
//        postRepo.(id,modelMapper.map(postDto,Post.class));
//    }

//    @Override
//    public List<PostDto> getPostsByAuthor(String author) {
//        return  listMapper.mapList(postRepo.getPostsByAuthor(author),new PostDto());
//    }
//
//    @Override
//    public List<Post> searchPostsByAuthor(String text) {
//        return postRepo.searchPostsByAuthor(text);
//        return  listMapper.mapList(postRepo.searchPostsByAuthor(text),new PostDto());
//    }
}
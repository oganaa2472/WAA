package com.miu.demo.service.impl;


import com.miu.demo.domain.Post;
import com.miu.demo.domain.dto.PostDto;
import com.miu.demo.helper.ListMapper;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Autowired
    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    public List<PostDto> findAll() {
        return listMapper.mapList(postRepo.findAll(),new PostDto());
    }
    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id),PostDto.class);
    }

    @Override
    public void save(Post post) {
         postRepo.save(modelMapper.map(post,Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

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
//    public List<PostDto> searchPostsByAuthor(String text) {
//        return  listMapper.mapList(postRepo.searchPostsByAuthor(text),new PostDto());
//    }
}
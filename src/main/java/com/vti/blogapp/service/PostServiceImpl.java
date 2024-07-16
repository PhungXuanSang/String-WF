package com.vti.blogapp.service;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.from.PostCreateFrom;
import com.vti.blogapp.from.PostUpdateFrom;
import com.vti.blogapp.mapper.PostMapper;
import com.vti.blogapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    private PostRepository postRepository ;

    @Override
    public Page<PostDto> fillAll(Pageable pageable) {

    return postRepository.findAll(pageable)  // Page<Post>
             .map(PostMapper ::map);

    }

    @Override
    public PostDto findById(Long id) {
     return postRepository.findById(id)
             .map(PostMapper::map)
             .orElse(null);
    }

    @Override
    public PostDto create(PostCreateFrom from) {
        var post = PostMapper.map(from);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(Long id, PostUpdateFrom from) {
     var optional =  postRepository.findById(id);
     if (optional.isEmpty()){
         return null;
     }
     var post = optional.get();
     PostMapper.map(from,post);
     var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
            postRepository.deleteById(id);
    }
}

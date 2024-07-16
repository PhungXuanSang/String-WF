package com.vti.blogapp.controller;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.from.PostCreateFrom;
import com.vti.blogapp.from.PostUpdateFrom;
import com.vti.blogapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService ;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(Pageable pageable){
        return postService.fillAll(pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") Long id){
        return postService.findById(id);

    }
    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody PostCreateFrom from){
        return postService.create(from);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@PathVariable("id") Long id ,@RequestBody PostUpdateFrom from){
        return postService.update(id,from);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }

}

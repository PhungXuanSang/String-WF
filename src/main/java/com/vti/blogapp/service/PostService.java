package com.vti.blogapp.service;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.from.PostCreateFrom;
import com.vti.blogapp.from.PostUpdateFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    Page<PostDto> fillAll(Pageable pageable);
    PostDto findById(Long id);
    PostDto create(PostCreateFrom from);
    PostDto update(Long id,PostUpdateFrom from);
    void deleteById(Long id);

}

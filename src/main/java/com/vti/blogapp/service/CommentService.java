package com.vti.blogapp.service;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.from.CommentCreateFrom;
import com.vti.blogapp.from.CommentUpdateFrom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(Long postId, CommentCreateFrom form);

    CommentDto update(Long id, CommentUpdateFrom form);

    void deleteById(Long id);

    void deleteByEmail(String email);
}
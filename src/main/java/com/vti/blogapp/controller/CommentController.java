package com.vti.blogapp.controller;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.from.CommentCreateFrom;
import com.vti.blogapp.from.CommentUpdateFrom;
import com.vti.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(@PathVariable("postId") Long postId, Pageable pageable) {
        return commentService.findByPostId(postId, pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PathVariable("postId") Long postId,
            @RequestBody CommentCreateFrom from) {
        return commentService.create(postId, from);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @PathVariable("id") Long id,
            @RequestBody CommentUpdateFrom from
    ) {
        return commentService.update(id, from);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(
            @PathVariable("id") Long id

    ) {
        commentService.deleteById(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String email) {
        commentService.deleteByEmail(email);
    }
}

package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.from.CommentCreateFrom;
import com.vti.blogapp.from.CommentUpdateFrom;

public class CommentMapper {
    public static Comment map(CommentCreateFrom form) {
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }
    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
    public static void map(CommentUpdateFrom from,Comment comment){
        comment.setName(from.getName());
        comment.setEmail(from.getEmail());
        comment.setBody(from.getBody());
    }

}

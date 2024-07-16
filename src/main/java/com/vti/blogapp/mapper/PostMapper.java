package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.from.PostCreateFrom;
import com.vti.blogapp.from.PostUpdateFrom;

public class PostMapper {
    public static Post map(PostCreateFrom from){
        var post = new Post();
        post.setTitle(from.getTitle());
        post.setContent(from.getContent());
        post.setDescription(from.getDescription());
        post.setStatus(from.getStatus());
        return post;
    }
    public static PostDto map(Post post){
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setCreateAt(post.getCreateAt());
        dto.setUpdateAt(post.getUpdateAt());
        dto.setStatus(post.getStatus());
        return dto;
    }

    public static void map(PostUpdateFrom from, Post post){
        post.setTitle(from.getTitle());
        post.setContent(from.getContent());
        post.setDescription(from.getDescription());
        post.setStatus(from.getStatus());
    }

}

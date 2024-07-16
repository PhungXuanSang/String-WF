package com.vti.blogapp.from;

import com.vti.blogapp.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateFrom {
    private String title;
    private String content;
    private String description;
    private Post.Status status;
}

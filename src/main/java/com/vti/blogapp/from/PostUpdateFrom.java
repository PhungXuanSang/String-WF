package com.vti.blogapp.from;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateFrom {
    private String title;
    private String content;
    private String description;
    private Post.Status status;
}

package com.vti.blogapp.from;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentCreateFrom {

    private String name;
    private String email;
    private String body;

}

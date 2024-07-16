package com.vti.blogapp.entity;

import com.vti.blogapp.converter.PostStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity (name = "post")

public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "title" , length = 50, nullable = false)
    private String title;

    @Column(name = "content" , length = 500, nullable = false)
    private String content;

    @Column(name = "description" , length = 100, nullable = false)
    private String description;

    @Column(name = "status" , nullable = false)
    // @Enumerated(value = EnumType.STRING)
    @Convert(converter = PostStatusConverter.class)
    private Status status;

    @Column(name = "create_at" , length = 50, nullable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "update_at" , length = 50, nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public enum Status{
        OPENING,CLOSED
    }

}

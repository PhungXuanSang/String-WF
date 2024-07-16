package com.vti.blogapp.converter;

import com.vti.blogapp.entity.Post;
import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;

public class PostStatusConverter implements AttributeConverter<Post.Status, Character> {
    @Override
    public Character convertToDatabaseColumn(Post.Status status) {
        return status.toString().charAt(0);
    }

    @SneakyThrows
    @Override
    public Post.Status convertToEntityAttribute(Character code) {
        if (code=='o') return Post.Status.OPENING;
        if (code=='c') return Post.Status.CLOSED;
        throw new IllegalAccessException(code.toString());

    }
}

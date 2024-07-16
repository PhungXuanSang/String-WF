package com.vti.blogapp.service;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.from.CommentCreateFrom;
import com.vti.blogapp.from.CommentUpdateFrom;
import com.vti.blogapp.mapper.CommentMapper;
import com.vti.blogapp.repository.CommentRepository;
import com.vti.blogapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Override
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);

    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {

        return commentRepository.findByPostId(postId,pageable)
                .map(CommentMapper:: map);
    }

    @Override
    public CommentDto findById(Long id) {
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDto create(Long postId, CommentCreateFrom from) {
        var optional = postRepository.findById(postId);
        if (optional.isEmpty()) {
            return null;
        } else {
            var post = optional.get();
            var comment = CommentMapper.map(from);
            comment.setPost(post);
            var saveComment = commentRepository.save(comment);
            return CommentMapper.map(saveComment);
        }
    }

    @Override
    public CommentDto update(Long id, CommentUpdateFrom from) {
        var optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        } else {
            var comment = optional.get();
            CommentMapper.map(from, comment);
            var savedComment = commentRepository.save(comment);
            return CommentMapper.map(savedComment);
        }
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        commentRepository.deleteByEmail(email);
    }
}

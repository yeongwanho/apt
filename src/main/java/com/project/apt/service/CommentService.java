package com.project.apt.service;

import com.project.apt.entity.Comments;
import com.project.apt.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveComment(Comments comments){
        commentRepository.save(comments);
    }
}

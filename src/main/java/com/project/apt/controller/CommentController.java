package com.project.apt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.dto.RequestComment;
import com.project.apt.entity.Apt;
import com.project.apt.entity.Comments;
import com.project.apt.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private ObjectMapper objectMapper=new ObjectMapper();
    @PostMapping("/api/apt/comment")
    public void commentSave(@RequestBody String comment) throws JsonProcessingException {
        Comments commentVo = new Comments();
        RequestComment comments = objectMapper.readValue(comment, RequestComment.class);
        Apt apt = new Apt();
        System.out.println(comments.getAptId());
        apt.setId(comments.getAptId());
        commentVo.setContent(comments.getContent());
        commentVo.setLoginId(comments.getLoginId());
        commentVo.setCreateDate(LocalDateTime.now());
        commentVo.setUseYn("Y");
        commentVo.setApt(apt);
        commentService.saveComment(commentVo);


    }
}

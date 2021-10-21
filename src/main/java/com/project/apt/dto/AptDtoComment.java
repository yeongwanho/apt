package com.project.apt.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AptDtoComment {

    private Long aptId;

    private Long commentId;

    private LocalDateTime createDate;

    private String content;

    private String loginId;

    @QueryProjection

    public AptDtoComment(Long aptId, Long commentId, LocalDateTime createDate, String content, String loginId) {
        this.aptId = aptId;
        this.commentId = commentId;
        this.createDate = createDate;
        this.content = content;
        this.loginId = loginId;
    }
}

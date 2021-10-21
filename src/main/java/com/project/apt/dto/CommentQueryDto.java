package com.project.apt.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentQueryDto {

    private Long aptId;

    private String aptName;

    private String ContractDate;

    private String price;

    private String loginId;

    private List<AptDtoComment> comments;

    private String content;

    private LocalDateTime createDate;

    @QueryProjection
    public CommentQueryDto(Long aptId, String aptName, String contractDate, String price, String loginId, List<AptDtoComment> comments, String content, LocalDateTime createDate) {
        this.aptId = aptId;
        this.aptName = aptName;
        ContractDate = contractDate;
        this.price = price;
        this.loginId = loginId;
        this.comments = comments;
        this.content = content;
        this.createDate = createDate;
    }




    @QueryProjection
    public CommentQueryDto(Long aptId, String aptName, String contractDate, String price) {
        this.aptId = aptId;
        this.aptName = aptName;
        ContractDate = contractDate;
        this.price = price;
    }







}

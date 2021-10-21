package com.project.apt.dto;

import lombok.Data;

@Data
public class RequestComment {

    private Long aptId;

    private String loginId;

    private String content;
}

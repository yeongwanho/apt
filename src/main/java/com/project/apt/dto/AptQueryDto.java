package com.project.apt.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AptQueryDto {

    private Long aptId;

    private String cityL;

    private String cityM;

    private String cityS;

    private String aptName;

    private String aptRow;

    private String ContractDate;

    private String price;

    @QueryProjection
    public AptQueryDto(Long aptId, String cityL, String cityM, String cityS, String aptName, String aptRow, String contractDate, String price) {
        this.aptId = aptId;
        this.cityL = cityL;
        this.cityM = cityM;
        this.cityS = cityS;
        this.aptName = aptName;
        this.aptRow = aptRow;
        ContractDate = contractDate;
        this.price = price;
    }
}

package com.airpremia.eosh.personaldetail.basicinfo.controller;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BasicInfoUpdateResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 ID")
    private String userId;
    @Schema(description = "사용자 '직군' 분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;


    public BasicInfoUpdateResponse(BasicInfoUpdateRequest req) {
        this.userId = req.getUserId();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
    }
}


package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.util.List;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasicInfoUpdateRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 ID")
    private String userId;
    @Schema(description = "사용자 '직군' 분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "안전보건관리조직")
    private List<UserSafetyOfficeLogRequest> userSafetyOfficeLogRequest;
    @Schema(description = "자격증")
    private List<UserQualificationItemRequest> userQualificationItemRequest;
}


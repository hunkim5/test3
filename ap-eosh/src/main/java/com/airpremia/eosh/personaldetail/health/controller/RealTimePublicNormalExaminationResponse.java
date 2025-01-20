package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RealTimePublicNormalExaminationResponse {
    @Schema(description = "생년월일 이름")
    private String birthDtName;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "생년월일")
    private String birthDtString;
    @Schema(description = "사용자 '직군'분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationclassificationEnum;
    @Schema(description = "'위암' 여부 코드")
    private String stomachCancerBoolCode;
    @Schema(description = "'구강검진' 여부 코드")
    private String oralExamBoolCode;
    @Schema(description = "'유방암' 여부 코드")
    private String breastCancerBoolCode;
    @Schema(description = "'대장암' 여부 코드")
    private String colonCancerBoolCode;
    @Schema(description = "'자궁경부암' 여부 코드")
    private String cervicalCancerBoolCode;
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;

}


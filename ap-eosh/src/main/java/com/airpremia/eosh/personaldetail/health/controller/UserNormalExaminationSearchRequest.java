package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserNormalExaminationSearchRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 이름")
    private String empNm;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "부서 이름")
    private String deptNm;
    @Schema(description = "생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사번")
    private String empNo;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "근무구분 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "'일반검진' 여부 코드")
    private String normalExaminationCode;
    @Schema(description = "'구강검진' 여부 코드")
    private String oralExamBoolCode;
    @Schema(description = "'위암' 여부 코드")
    private String stomachCancerBoolCode;
    @Schema(description = "'유방암' 여부 코드")
    private String breastCancerBoolCode;
    @Schema(description = "'대장암' 여부 코드")
    private String colonCancerBoolCode;
    @Schema(description = "'자궁경부암' 여부 코드")
    private String cervicalCancerBoolCode;
}


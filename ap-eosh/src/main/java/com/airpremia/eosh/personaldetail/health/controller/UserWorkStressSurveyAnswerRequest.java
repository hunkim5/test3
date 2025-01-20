package com.airpremia.eosh.personaldetail.health.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveyAnswerRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "평가항목 코드")
    private String evaluationItemCode;
    @Schema(description = "질문 코드")
    private String questionCode;
    @Schema(description = "점수")
    private int score;
    @Schema(description = "성별")
    private String sex;
    @Schema(description = "부서 코드")
    private String deptCd;
    @Schema(description = "평가 항목 코드")
    private String evaluationItemName;
}


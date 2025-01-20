package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyDto;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserWorkStressSurveyResponse {

    @Schema(description = "답변 시퀀스")
    private String userWorkStressSurveyAnswerSeq;
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "기준년")
    private String standardYyyy;
    @Schema(description = "항목 코드")
    private String evaluationItemCode;
    @Schema(description = "질문 코드")
    private String questionCode;
    @Schema(description = "점수")
    private int score;
    @Schema(description = "성별")
    private UserSexEnum sex;


    public UserWorkStressSurveyResponse(UserWorkStressSurveyDto req) {
        this.userWorkStressSurveyAnswerSeq = req.getUserWorkStressSurveyAnswerSeq();
        this.userSeq = req.getUserSeq();
        this.standardYyyy = req.getStandardYyyy();
        this.evaluationItemCode = req.getEvaluationItemCode();
        this.questionCode = req.getQuestionCode();
        this.score = req.getScore();
        this.sex = req.getSex();
    }

}


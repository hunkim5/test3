package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyAnswerRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserWorkStressSurveyAnswerDto {
    private Long userSeq;

    private String userId;

    private String standardYyyy;

    private String evaluationItemCode;

    private String questionCode;

    private int score;

    private String sex;

    private String deptCd;

    private String evaluationItemName;

    private String insertUserId;
    private String insertIp;
    private LocalDateTime insertDtm;
    private String updateUserId;
    private String updateIp;
    private LocalDateTime updateDtm;

    public UserWorkStressSurveyAnswerDto(UserWorkStressSurveyAnswerRequest data) {
        this.userSeq = data.getUserSeq();
        this.userId = data.getUserId();
        this.standardYyyy = data.getStandardYyyy();
        this.evaluationItemCode = data.getEvaluationItemCode();
        this.questionCode = data.getQuestionCode();
        this.score = data.getScore();
        this.deptCd = data.getDeptCd();
        this.evaluationItemName = data.getEvaluationItemName();
    }
}


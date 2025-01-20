package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveyDto {

    private String userWorkStressSurveyAnswerSeq;
    private Long userSeq;
    private String standardYyyy;
    private String evaluationItemCode;
    private String questionCode;
    private int score;
    private UserSexEnum sex;

}


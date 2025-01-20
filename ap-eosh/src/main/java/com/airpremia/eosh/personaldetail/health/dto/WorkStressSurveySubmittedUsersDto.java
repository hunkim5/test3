package com.airpremia.eosh.personaldetail.health.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkStressSurveySubmittedUsersDto {
    private Long userSeq;
    private String standardYyyy;
    private double averageScore;
    private String surveyStatus;
}


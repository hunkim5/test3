package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.personaldetail.health.enums.StressSurveyCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkStressSurveyReportDto {

    private String standardYyyy;
    private StressSurveyCodeEnum evaluationItemCode;
    private String deptCd;
    private String deptNm;
    private int score;
    private UserSexEnum sex;
    private Long userSeq;
    private String userId;
    private String empNm;
    private double formulaScore;
    private double companyAverageScore;
    private double deptAverageScore;

}


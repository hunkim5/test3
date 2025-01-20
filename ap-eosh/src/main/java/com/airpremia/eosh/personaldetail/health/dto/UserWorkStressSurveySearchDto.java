package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveySearchDto {
    private Long userSeq;
    private String userId;
    private String standardYyyy;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private String surveyStatus;
    private String deptCd;
    private String deptNm;
    private String empNm;
    private UserSexEnum sex;
}


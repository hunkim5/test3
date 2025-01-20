package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveyPageDto {
    private Long userSeq;

    private String userId;

    private String standardYyyy;

    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;

    private int averageScore;

    private String surveyStatus;

    private String empNm;

    private String empNo;

    private String deptNm;

    private String deptCd;

    private UserSexEnum sex;

    public void setHrInfo(HrEmpDto empDto) {
        this.empNm = empDto.getEmpNm();
        this.deptNm = empDto.getDeptNm();
    }
}


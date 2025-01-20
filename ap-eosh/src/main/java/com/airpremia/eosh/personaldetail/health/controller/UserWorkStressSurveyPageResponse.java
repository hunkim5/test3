package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyPageDto;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserWorkStressSurveyPageResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "직군 분류")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "평균 점수")
    private double averageScore;
    @Schema(description = "설문 상태")
    private String surveyStatus;
    @Schema(description = "사용자 이름")
    private String empNm;
    @Schema(description = "사용자 아이디")
    private String empNo;
    @Schema(description = "부서 이름")
    private String deptNm;
    @Schema(description = "부서 코드")
    private String deptCd;
    @Schema(description = "성별")
    private UserSexEnum sex;

    public UserWorkStressSurveyPageResponse(UserWorkStressSurveyPageDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.averageScore = req.getAverageScore();
        this.surveyStatus = req.getSurveyStatus();
        this.empNm = req.getEmpNm();
        this.empNo = req.getEmpNo();
        this.deptNm = req.getDeptNm();
        this.deptCd = req.getDeptCd();
        this.sex = req.getSex();
    }

    public UserWorkStressSurveyPageResponse(UserWorkStressSurveyPageResponse res) {
        this.userSeq = res.getUserSeq();
        this.userId = res.getUserId();
        this.standardYyyy = res.getStandardYyyy();
        this.userJobClassificationClassificationEnum = res.getUserJobClassificationClassificationEnum();
        this.averageScore = res.getAverageScore();
        this.surveyStatus = res.getSurveyStatus();
        this.empNm = res.getEmpNm();
        this.empNo = res.getEmpNo();
        this.deptNm = res.getDeptNm();
        this.deptCd = res.getDeptCd();
        this.sex = res.getSex();
    }

    public void mergeInfo(UserWorkStressSurveyPageResponse dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
    }
}


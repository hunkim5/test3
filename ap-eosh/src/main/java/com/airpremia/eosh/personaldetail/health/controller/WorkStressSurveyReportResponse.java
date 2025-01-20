package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveyReportDto;
import com.airpremia.eosh.personaldetail.health.enums.StressSurveyCodeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkStressSurveyReportResponse {
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "항목 코드")
    private StressSurveyCodeEnum evaluationItemCode;
    @Schema(description = "남자 통계 점수")
    private int score;
    @Schema(description = "계산식 점수")
    private double formulaScore;
    @Schema(description = "회사 평균")
    private double companyAverageScore;
    @Schema(description = "부서 평균")
    private double deptAverageScore;

    public WorkStressSurveyReportResponse(WorkStressSurveyReportDto req) {
        this.standardYyyy = req.getStandardYyyy();
        this.evaluationItemCode = req.getEvaluationItemCode();
        this.score = req.getScore();
        this.formulaScore = req.getFormulaScore();
        this.companyAverageScore = req.getCompanyAverageScore();
        this.deptAverageScore = req.getDeptAverageScore();
    }
}


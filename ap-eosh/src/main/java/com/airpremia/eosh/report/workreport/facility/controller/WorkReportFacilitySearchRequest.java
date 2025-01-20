package com.airpremia.eosh.report.workreport.facility.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkReportFacilitySearchRequest {
    @Schema(description = "설비 시퀀스")
    private Long facilitySeq;
    @Schema(description = "업무 설비 분류 ENUM")
    private WorkFacilityClassificationEnum workFacilityClassificationEnum;
    @Schema(description = "도입 코드")
    private String introductionCode;
    @Schema(description = "도입 설비 코드")
    private String introductionFacilityCode;
    @Schema(description = "도입 부서")
    private String introductionDepartment;
    @Schema(description = "제품 이름")
    private String productName;
    @Schema(description = "모델 이름")
    private String modelName;
    @Schema(description = "모델 번호")
    private String modelNumber;
    @Schema(description = "제목")
    private String title;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "제품 제조사 이름")
    private String productManufacturerName;
    @Schema(description = "안전 검사 날짜")
    private LocalDate safetyInspectionDt;
    @Schema(description = "제품 제조사 전화번호")
    private String productManufacturerPhoneno;
    @Schema(description = "안전 검사 만료 날짜")
    private LocalDate safetyInspectionExpirationDt;
    @Schema(description = "신규 도입 장소")
    private String newIntroductionLocation;
    @Schema(description = "추가 설명")
    private String addComment;
    @Schema(description = "다중 파일 안전인증 UUID")
    private String multipleFileSafetycertificationUuid;
    @Schema(description = "다중 파일 안전검사 UUID")
    private String multipleFileSafetyinspectionUuid;
    @Schema(description = "다중 파일 자율안전 UUID")
    private String multipleFileAutonomysafetyUuid;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "보고서 번호")
    private String reportNo;
}


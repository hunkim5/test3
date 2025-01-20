package com.airpremia.eosh.report.workreport.safeguarding.controller;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingSearchRequest {
    @Schema(description = "요청 부서")
    private String requestDepartment;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "작업 구분 코드")
    private String jobDivisionCode;
    @Schema(description = "신규 구분 코드")
    private String newDivisionCode;
    @Schema(description = "안전방호 코드")
    private String safeguardingCode;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "보호구세부 코드")
    private String protectGearDetailCode;
    @Schema(description = "제품 제조사 이름")
    private String productManufacturerName;
    @Schema(description = "제품 제조사 전화번호")
    private String productManufacturerPhoneno;
    @Schema(description = "제품 이름")
    private String productName;
    @Schema(description = "제품 모델 이름")
    private String productModelName;
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "요청 사용자 아이디")
    private String requestUserId;
    @Schema(description = "안전 인증 여부")
    private boolean safetyCertificationBool;
    @Schema(description = "자율 안전 확인 신고 여부")
    private boolean autonomySafetyCheckReportBool;
    @Schema(description = "안전 검사 여부")
    private boolean safetyInspectionBool;
    @Schema(description = "기타 여부")
    private boolean etcBool;
}


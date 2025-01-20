package com.airpremia.eosh.report.workreport.safeguarding.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingRequest {
    @Schema(description = "안전방호 시퀀스")
    private Long safeguardingSeq;
    @Schema(description = "요청 부서")
    private String requestDepartment;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "작업 구분 코드")
    private String jobDivisionCode;
    @Schema(description = "안전 인증 여부")
    private boolean safetyCertificationBool;
    @Schema(description = "자율 안전 확인 신고 여부")
    private boolean autonomySafetyCheckReportBool;
    @Schema(description = "안전 검사 여부")
    private boolean safetyInspectionBool;
    @Schema(description = "기타 여부")
    private boolean etcBool;
    @Schema(description = "이동 지역 등록 번호")
    private String movementAreaRegistrationNo;
    @Schema(description = "신규 구분 코드")
    private String newDivisionCode;
    @Schema(description = "안전방호 코드")
    private String safeguardingCode;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "제품 제조사 이름")
    private String productManufacturerName;
    @Schema(description = "제품 제조사 전화번호")
    private String productManufacturerPhoneno;
    @Schema(description = "제품 제조사 이메일")
    private String productManufacturerEmail;
    @Schema(description = "제품 이름")
    private String productName;
    @Schema(description = "제품 모델 이름")
    private String productModelName;
    @Schema(description = "추가 설명")
    private String addDescription;
    @Schema(description = "다중 파일 안전인증 UUID")
    private String multipleFileSafetycertificationUuid;
    @Schema(description = "다중 파일 안전검사 UUID")
    private String multipleFileSafetyinspectionUuid;
    @Schema(description = "다중 파일 자율안전 UUID")
    private String multipleFileAutonomysafetyUuid;
    @Schema(description = "방호장치 수량")
    private int protectionDeviceQuantity;
    @Schema(description = "보호구 수량")
    private int protectGearQuantity;
    @Schema(description = "요청부서 이름")
    private String requestDepartmentName;
    @Schema(description = "요청 사용자 아이디")
    private String requestUserId;
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "보호구 세부 코드")
    private String protectGearDetailCode;
    @Schema(description = "등록 일자")
    private LocalDate registrationDt;
    @Schema(description = "말소 일자")
    private LocalDate expirationDt;
    @Schema(description = "제조 일자")
    private LocalDate manufacturingDt;
    @Schema(description = "폐기 일자")
    private LocalDate disposalDt;
    @Schema(description = "교체 권장 조건")
    private String replacementRecommendCondition;
    @Schema(description = "보완요청 사유")
    private String rejectReason;
    @Schema(description = "제목")
    private String subject;
    @Schema(description = "요청 사용자 이름")
    private String requestUserName;
}

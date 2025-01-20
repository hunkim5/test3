package com.airpremia.eosh.report.workreport.facility.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportFacilityResponse {
    @Schema(description = "설비 시퀀스")
    private Long facilitySeq;
    @Schema(description = "업무 설비 분류 ENUM")
    private WorkFacilityClassificationEnum workFacilityClassificationEnum;
    @Schema(description = "제목")
    private String title;
    @Schema(description = "도입 코드")
    private String introductionCode;
    @Schema(description = "도입 설비 코드")
    private String introductionFacilityCode;
    @Schema(description = "제품 이름")
    private String productName;
    @Schema(description = "모델 이름")
    private String modelName;
    @Schema(description = "모델 번호")
    private String modelNumber;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "제품 제조사 이름")
    private String productManufacturerName;
    @Schema(description = "안전 검사 날짜")
    private LocalDate safetyInspectionDt;
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
    @Schema(description = "등록 날짜")
    private LocalDate registrationDt;
    @Schema(description = "말소 날짜")
    private LocalDate expirationDt;
    @Schema(description = "최초 검사일")
    private LocalDate firstTimeInspectionDt;
    @Schema(description = "제품 제조사 전화번호")
    private String productManufacturerPhoneno;
    @Schema(description = "제품 제조사 이메일")
    private String productManufacturerEmail;
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
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "요청 부서")
    private String requestDepartment;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "보완요청 사유")
    private String rejectReason;
}


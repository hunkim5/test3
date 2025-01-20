package com.airpremia.eosh.report.workreport.reportcontract.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReportContractResponse {
    @Schema(description = "계약 시퀀스")
    private Long contractSeq;
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "계약 담당 부서 코드")
    private String contractInchargeDepartmentCode;
    @Schema(description = "계약 담당 부서 이름")
    private String contractInchargeDepartmentName;
    @Schema(description = "계약 담당 아이디")
    private String contractInchargeId;
    @Schema(description = "계약 담당 이름")
    private String contractInchargeName;
    @Schema(description = "계약 업체 이름")
    private String contractCompanyName;
    @Schema(description = "계약 업체 담당 이름")
    private String contractCompanyInchargeName;
    @Schema(description = "계약 업체 연락처")
    private String contractCompanyContact;
    @Schema(description = "계약 업체 이메일")
    private String contractCompanyEmail;
    @Schema(description = "계약 단계 코드")
    private String contractPhaseCode;
    @Schema(description = "상위 업체 1 순서")
    private int topCompanyOneOrder;
    @Schema(description = "상위 업체 2 순서")
    private int topCompanyTwoOrder;
    @Schema(description = "상위 업체 3 순서")
    private int topCompanyThreeOrder;
    @Schema(description = "업체 등급 ENUM")
    private CompanyGradeEnum companyGradeEnum;
    @Schema(description = "협력 업체 작업장 코드")
    private String partnerCompanyWorkplaceCode;
    @Schema(description = "협력 업체 작업장 text")
    private String partnerCompanyWorkplaceText;
    @Schema(description = "관리 작업장 여부")
    private boolean managementWorkplaceBool;
    @Schema(description = "협력 주요 업무")
    private String partnerMajorWork;
    @Schema(description = "'수급계약' 여부")
    private boolean subcontractingBool;
    @Schema(description = "'수급계약' 업체 이름")
    private String subcontractingCompanyName;
    @Schema(description = "추가 comment")
    private String addComment;
    @Schema(description = "첨부 다중 파일 UUID")
    private String attachMultipleFileUuid;
    @Schema(description = "FEEDBACK 내용")
    private String feedbackContent;
    @Schema(description = "거부근거")
    private String rejectReason;
    @Schema(description = "안전 조치 대상 여부")
    private boolean safetyActionTargetBool;
    @Schema(description = "안전 보건 협의체 여부")
    private boolean safetyHealthConsultativeGroupBool;
    @Schema(description = "안전 보건 점검 여부")
    private boolean safetyHealthCheckBool;
    @Schema(description = "평가 대상 여부")
    private boolean evaluationTargetBool;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "작업 60 일 여부")
    private boolean job60DayBool;
    @Schema(description = "납품 여부")
    private boolean deliveryBool;
    @Schema(description = "설치 유지 여부")
    private boolean installationMaintenanceBool;
    @Schema(description = "출입 업체 여부")
    private boolean enterCompanyBool;
    @Schema(description = "정기 검사 여부")
    private boolean routineInspectionBool;
    @Schema(description = "해당없음 여부")
    private boolean notApplicableBool;
    @Schema(description = "판단 여부")
    private boolean judgmentBool;
    @Schema(description = "협력 업체 담당 이름")
    private String partnerCompanyInchargeName;
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
}


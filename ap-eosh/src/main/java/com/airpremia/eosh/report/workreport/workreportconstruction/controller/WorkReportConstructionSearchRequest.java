package com.airpremia.eosh.report.workreport.workreportconstruction.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkConstructionClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkReportConstructionSearchRequest {
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "업무 보고서 제목")
    private String workReportSubject;
    @Schema(description = "업무 건설물 분류 ENUM")
    private WorkConstructionClassificationEnum workConstructionClassificationEnum;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "업무 예상 날짜")
    private LocalDate workExpectDt;
    @Schema(description = "수행 업체 이름")
    private String performCompanyName;
    @Schema(description = "수행 담당 전화번호")
    private String performInchargePhoneno;
    @Schema(description = "출처 주소")
    private String sourceAddress;
    @Schema(description = "대상 주소")
    private String targetAddress;
    @Schema(description = "정비 내용")
    private String maintenanceContent;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;

}


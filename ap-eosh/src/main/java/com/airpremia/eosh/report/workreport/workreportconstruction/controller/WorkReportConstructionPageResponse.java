package com.airpremia.eosh.report.workreport.workreportconstruction.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.dto.WorkReportConstructionPageDto;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkConstructionClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportConstructionPageResponse {
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "정비 내용")
    private String maintenanceContent;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "수행 업체 이름")
    private String performCompanyName;
    @Schema(description = "수행 담당 전화번호")
    private String performInchargePhoneno;
    @Schema(description = "출처 주소")
    private String sourceAddress;
    @Schema(description = "대상 주소")
    private String targetAddress;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "업무 건설물 분류 ENUM")
    private WorkConstructionClassificationEnum workConstructionClassificationEnum;
    @Schema(description = "업무 예상 날짜")
    private LocalDate workExpectDt;
    @Schema(description = "업무 보고서 건설물 시퀀스")
    private Long workReportConstructionSeq;
    @Schema(description = "업무 보고서 제목")
    private String workReportSubject;
    @Schema(description = "보고서 번호")
    private String reportNo;

    public WorkReportConstructionPageResponse(WorkReportConstructionPageDto req) {
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeUserId = req.getInchargeUserId();
        this.maintenanceContent = req.getMaintenanceContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.performCompanyName = req.getPerformCompanyName();
        this.performInchargePhoneno = req.getPerformInchargePhoneno();
        this.sourceAddress = req.getSourceAddress();
        this.targetAddress = req.getTargetAddress();
        this.workConstructionClassificationEnum = req.getWorkConstructionClassificationEnum();
        this.workExpectDt = req.getWorkExpectDt();
        this.workReportConstructionSeq = req.getWorkReportConstructionSeq();
        this.workReportSubject = req.getWorkReportSubject();
        this.reportNo = req.getReportNo();
        this.insertDtm = req.getInsertDtm();
    }
}


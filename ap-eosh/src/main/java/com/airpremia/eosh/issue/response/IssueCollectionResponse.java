package com.airpremia.eosh.issue.response;

import java.time.LocalDateTime;

import com.airpremia.eosh.issue.enums.IssueAppvalprcEnum;
import com.airpremia.eosh.issue.enums.IssueProcessingEnum;
import com.airpremia.eosh.issue.enums.IssueTargetEnum;
import com.airpremia.esmsfos.core.enums.ReportClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IssueCollectionResponse {
    @Schema(description = "ISSUE 시퀀스")
    private Long issueSeq;
    @Schema(description = "조사 시퀀스")
    private Long investigationSeq;
    @Schema(description = "ISSUE 아이디")
    private String issueId;
    @Schema(description = "출처 아이디")
    private String sourceId;
    @Schema(description = "보고서 분류 ENUM")
    private ReportClassificationEnum reportClassificationEnum;
    @Schema(description = "ISSUE 대상 ENUM")
    private IssueTargetEnum issueTargetEnum;
    @Schema(description = "ISSUE 처리 ENUM")
    private IssueProcessingEnum issueProcessingEnum;
    @Schema(description = "ISSUE 승인절차 ENUM")
    private IssueAppvalprcEnum issueAppvalprcEnum;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "조사 처리 여부")
    private boolean investigationProcessingBool = false;
    @Schema(description = "ISSUE 제목")
    private String issueSubject;
    @Schema(description = "ISSUE 종료 일시")
    private LocalDateTime issueEndDtm;
    @Schema(description = "ISSUE 등록 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "보고서 삽입 일시")
    private LocalDateTime reportInsertDtm;
    @Schema(description = "ReportClassification 여부")
    private boolean reportClassificationBool = false;

}

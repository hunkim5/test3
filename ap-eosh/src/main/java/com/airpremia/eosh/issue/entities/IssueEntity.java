package com.airpremia.eosh.issue.entities;

import java.time.LocalDateTime;

import com.airpremia.eosh.issue.dto.issue.IssueCreateInitialPropertyDto;
import com.airpremia.eosh.issue.enums.IssueAppvalprcEnum;
import com.airpremia.eosh.issue.enums.IssueProcessingEnum;
import com.airpremia.eosh.issue.enums.IssueTargetEnum;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class IssueEntity {
    @Schema(description = "ISSUE 시퀀스")
    private Long issueSeq;
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "발생가능성 수준")
    private Integer likelihoodLevel;
    @Schema(description = "심각도 수준")
    private Integer severityLevel;
    @Schema(description = "사건 등급 코드")
    private String eventGradeCode;
    @Schema(description = "구독 시정조치 UUID")
    private String subscribeCaUuid;
    @Schema(description = "구독 HAZARD UUID")
    private String subscribeHazardUuid;
    @Schema(description = "ISSUE 아이디")
    private String issueId;
    @Schema(description = "출처 아이디")
    private String sourceId;
    @Schema(description = "ISSUE 대상 ENUM")
    private IssueTargetEnum issueTargetEnum;
    @Schema(description = "ISSUE 처리 ENUM")
    private IssueProcessingEnum issueProcessingEnum;
    @Schema(description = "ISSUE 승인절차 ENUM")
    private IssueAppvalprcEnum issueAppvalprcEnum;
    @Schema(description = "사고 분류 코드")
    private String accidentClassificationCode;
    @Schema(description = "RISK 평가 처리 여부")
    private boolean riskEvaluationProcessingBool = false;
    @Schema(description = "ISSUE 중단 여부")
    private boolean issueDropBool = false;
    @Schema(description = "기관 알림 여부")
    private boolean organizationAlarmBool = false;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "ISSUE 제목")
    private String issueSubject;
    @Schema(description = "FEEDBACK 내용")
    private String feedbackContent;
    @Schema(description = "ISSUE 종료 일시")
    private LocalDateTime issueEndDtm;
    @Schema(description = "보고서 삽입 일시")
    private LocalDateTime reportInsertDtm;
    @Schema(description = "ISSUE 승인절차 수정 일시")
    private LocalDateTime issueAppvalprcUpdateDtm;
    @Schema(description = "삭제 여부")
    private boolean deleteBool = false;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
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

    public IssueEntity(IssueCreateInitialPropertyDto issueCreateInitialPropertyDto) {
        this.likelihoodLevel = issueCreateInitialPropertyDto.getLikelihoodLevel();
        this.sourceId = issueCreateInitialPropertyDto.getSourceId();
        this.reportUuid = issueCreateInitialPropertyDto.getReportUuid();
        this.reportInsertDtm = issueCreateInitialPropertyDto.getReportInsertDtm();
        this.issueSubject = issueCreateInitialPropertyDto.getIssueSubject();
    }

    public IssueEntity(Long issueSeq, String sourceId) {
        this.issueSeq = issueSeq;
        this.sourceId = sourceId;
    }

    public void setInitialIssuePropertyCreateByReport(UserTokenDto userToken) {
        this.issueTargetEnum = IssueTargetEnum.REPORT;
        this.issueAppvalprcEnum = IssueAppvalprcEnum.OPEN;
        this.issueProcessingEnum = IssueProcessingEnum.OPEN;
        this.inchargeUserId = userToken.getEmpNo();
        this.inchargeUserName = userToken.getEmpName();
        this.inchargeDepartmentId = userToken.getDeptCd();
        this.inchargeDepartmentName = userToken.getDeptNm();
    }


}

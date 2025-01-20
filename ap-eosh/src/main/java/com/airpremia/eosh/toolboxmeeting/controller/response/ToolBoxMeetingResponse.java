package com.airpremia.eosh.toolboxmeeting.controller.response;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.jobplan.response.JobEmployeeResponse;
import com.airpremia.eosh.jobplan.response.ManageSupervisionEmployeeResponse;
import com.airpremia.eosh.toolboxmeeting.dto.ToolBoxMeetingDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ToolBoxMeetingResponse {
    @Schema(description = "'안전점검회의' 시퀀스")
    private Long toolBoxMeetingSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "작업 날짜")
    private LocalDate jobDt;
    @Schema(description = "작업 시작 날짜")
    private LocalDate jobDtStart;
    @Schema(description = "작업 종료 날짜")
    private LocalDate jobDtEnd;
    @Schema(description = "'안전점검회의' 제목")
    private String toolBoxMeetingSubject;
    @Schema(description = "'안전점검회의' 내용")
    private String toolBoxMeetingContent;
    @Schema(description = "잠재적 RISK 요인 코드")
    private String potentialRiskFactorCode;
    @Schema(description = "교육 내용")
    private String educationContent;
    @Schema(description = "교육 실시 comment")
    private String educationProcessComment;
    @Schema(description = "다중 첨부파일 UUID")
    private String multipleAttachfileUuid;
    @Schema(description = "작업 허가 여부")
    private boolean jobPermissionBool;
    @Schema(description = "작업 계획 여부")
    private boolean jobPlanBool;
    @Schema(description = "작업 점검표")
    private String jobChecklist;
    @Schema(description = "작업자 건강 상태 comment")
    private String workerHealthStatusComment;
    @Schema(description = "작업자 보호구 점검 comment")
    private String workerProtectGearCheckComment;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "근로자")
    private List<JobEmployeeResponse> jobEmployeeList;
    @Schema(description = "관리감독자")
    private List<ManageSupervisionEmployeeResponse> manageSupervisionEmployeeList;

    public ToolBoxMeetingResponse(ToolBoxMeetingDto req) {
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.jobDt = req.getJobDt();
        this.jobDtStart = req.getJobDtStart();
        this.jobDtEnd = req.getJobDtEnd();
        this.toolBoxMeetingSubject = req.getToolBoxMeetingSubject();
        this.toolBoxMeetingContent = req.getToolBoxMeetingContent();
        this.potentialRiskFactorCode = req.getPotentialRiskFactorCode();
        this.educationContent = req.getEducationContent();
        this.educationProcessComment = req.getEducationProcessComment();
        this.multipleAttachfileUuid = req.getMultipleAttachfileUuid();
        this.jobPermissionBool = req.isJobPermissionBool();
        this.jobPlanBool = req.isJobPlanBool();
        this.jobChecklist = req.getJobChecklist();
        this.workerHealthStatusComment = req.getWorkerHealthStatusComment();
        this.workerProtectGearCheckComment = req.getWorkerProtectGearCheckComment();
        this.insertUserId = req.getInsertUserId();
    }
}


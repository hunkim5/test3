package com.airpremia.eosh.toolboxmeeting.controller.request;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.jobplan.request.ManageSupervisionEmployeeRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ToolBoxMeetingRequest {
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
    @Schema(description = "근로자")
    private List<JobEmployeeRequest> jobEmployeeList;
    @Schema(description = "관리감독자")
    private List<ManageSupervisionEmployeeRequest> manageSupervisionEmployeeList;
}

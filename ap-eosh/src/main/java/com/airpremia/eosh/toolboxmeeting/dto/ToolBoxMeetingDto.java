package com.airpremia.eosh.toolboxmeeting.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.jobplan.dto.JobEmployeeDto;
import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;
import com.airpremia.eosh.jobplan.request.JobPlanRequest;
import com.airpremia.eosh.jobplan.response.JobEmployeeResponse;
import com.airpremia.eosh.jobplan.response.ManageSupervisionEmployeeResponse;
import com.airpremia.eosh.toolboxmeeting.controller.request.ToolBoxMeetingRequest;
import com.airpremia.eosh.toolboxmeeting.controller.response.ToolBoxMeetingResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ToolBoxMeetingDto {

    private Long toolBoxMeetingSeq;
    private Long jobSeq;
    private LocalDate jobDtStart;
    private LocalDate jobDtEnd;
    private LocalDate jobDt;
    private String toolBoxMeetingSubject;
    private String toolBoxMeetingContent;
    private String potentialRiskFactorCode;
    private String educationContent;
    private String educationProcessComment;
    private String multipleAttachfileUuid;
    private boolean jobPermissionBool;
    private boolean jobPlanBool;
    private String jobChecklist;
    private String workerHealthStatusComment;
    private String workerProtectGearCheckComment;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    private List<JobEmployeeDto> jobEmployeeDtoList;
    private List<ManageSupervisionEmployeeDto> manageSupervisionEmployeeDtoList;

    public ToolBoxMeetingDto(ToolBoxMeetingRequest req) {
        this.jobEmployeeDtoList = req.getJobEmployeeList().stream().map(JobEmployeeDto::new).toList();
        this.manageSupervisionEmployeeDtoList =
            req.getManageSupervisionEmployeeList().stream().map(ManageSupervisionEmployeeDto::new).toList();
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.jobDtStart = req.getJobDtStart();
        this.jobDtEnd = req.getJobDtEnd();
        this.jobDt = req.getJobDt();
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
    }

    public ToolBoxMeetingResponse convertToolBoxMeetingResponse() {
        ToolBoxMeetingResponse data = new ToolBoxMeetingResponse();
        data.setJobEmployeeList(this.jobEmployeeDtoList.stream().map(JobEmployeeResponse::new).toList());
        data.setManageSupervisionEmployeeList(this.manageSupervisionEmployeeDtoList.stream().map(
            ManageSupervisionEmployeeResponse::new).toList());
        data.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        data.setJobSeq(this.jobSeq);
        data.setJobDtStart(this.jobDtStart);
        data.setJobDtEnd(this.jobDtEnd);
        data.setJobDt(this.jobDt);
        data.setToolBoxMeetingSubject(this.toolBoxMeetingSubject);
        data.setToolBoxMeetingContent(this.toolBoxMeetingContent);
        data.setPotentialRiskFactorCode(this.potentialRiskFactorCode);
        data.setEducationContent(this.educationContent);
        data.setEducationProcessComment(this.educationProcessComment);
        data.setMultipleAttachfileUuid(this.multipleAttachfileUuid);
        data.setJobPermissionBool(this.jobPermissionBool);
        data.setJobPlanBool(this.jobPlanBool);
        data.setJobChecklist(this.jobChecklist);
        data.setWorkerHealthStatusComment(this.workerHealthStatusComment);
        data.setWorkerProtectGearCheckComment(this.workerProtectGearCheckComment);
        return data;
    }

    public ToolBoxMeetingDto(JobPlanRequest req) {
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.jobDt = req.getJobStartDt();
        this.toolBoxMeetingSubject = req.getJobSubject();
    }
}


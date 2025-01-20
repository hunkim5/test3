package com.airpremia.eosh.checklist.dto;

import java.time.LocalDate;

import com.airpremia.eosh.checklist.enums.ChecklistPerformEnum;
import com.airpremia.eosh.checklist.request.ChecklistRequest;
import com.airpremia.eosh.checklist.request.ChecklistSearchRequest;
import com.airpremia.eosh.checklist.response.ChecklistResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChecklistDto {
    private Long checklistSeq;
    private Long jobSeq;
    private String checklistDivisionCode;
    private ChecklistPerformEnum checklistPerformEnum;
    private String checklistSubject;
    private String inspectorId;
    private String inspectorName;
    private String inspectorDepartmentId;
    private String inspectorDepartmentName;
    private LocalDate checkStartDt;
    private LocalDate checkEndDt;
    private LocalDate checkDt;
    private String inspectionMatters;
    private String checkTarget;
    private String checkLocation;
    private String partnerCompany;
    private String weekBranchCode;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public ChecklistDto(ChecklistRequest req) {
        this.checklistSeq = req.getChecklistSeq();
        this.jobSeq = req.getJobSeq();
        this.checklistDivisionCode = req.getChecklistDivisionCode();
        this.checklistPerformEnum = req.getChecklistPerformEnum();
        this.checklistSubject = req.getChecklistSubject();
        this.inspectorId = req.getInspectorId();
        this.inspectorName = req.getInspectorName();
        this.inspectorDepartmentId = req.getInspectorDepartmentId();
        this.inspectorDepartmentName = req.getInspectorDepartmentName();
        this.checkDt = req.getCheckDt();
        this.inspectionMatters = req.getInspectionMatters();
        this.checkTarget = req.getCheckTarget();
        this.checkLocation = req.getCheckLocation();
        this.partnerCompany = req.getPartnerCompany();
        this.weekBranchCode = req.getWeekBranchCode();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }

    public ChecklistDto(ChecklistSearchRequest req) {
        this.checklistDivisionCode = req.getChecklistDivisionCode();
        this.checklistSubject = req.getChecklistSubject() != null ?
            String.format("%%%s%%", req.getChecklistSubject()) : null;
        this.inspectorId = req.getInspectorId();
        this.inspectorName = req.getInspectorName();
        this.inspectorDepartmentId = req.getInspectorDepartmentId();
        this.inspectorDepartmentName = req.getInspectorDepartmentName();
        this.checkStartDt = req.getCheckStartDt();
        this.checkEndDt = req.getCheckEndDt();
    }

    public ChecklistResponse convertChecklistResponse() {
        ChecklistResponse data = new ChecklistResponse();
        data.setChecklistSeq(this.checklistSeq);
        data.setJobSeq(this.jobSeq);
        data.setChecklistDivisionCode(this.checklistDivisionCode);
        data.setChecklistPerformEnum(this.checklistPerformEnum);
        data.setChecklistSubject(this.checklistSubject);
        data.setInspectorId(this.inspectorId);
        data.setInspectorName(this.inspectorName);
        data.setInspectorDepartmentId(this.inspectorDepartmentId);
        data.setInspectorDepartmentName(this.inspectorDepartmentName);
        data.setCheckDt(this.checkDt);
        data.setInspectionMatters(this.inspectionMatters);
        data.setCheckTarget(this.checkTarget);
        data.setCheckLocation(this.checkLocation);
        data.setPartnerCompany(this.partnerCompany);
        data.setWeekBranchCode(this.weekBranchCode);
        data.setInsertUserId(this.insertUserId);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}


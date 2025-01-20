package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.request.ManageSupervisionEmployeeRequest;
import com.airpremia.eosh.jobplan.response.ManageSupervisionEmployeeResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ManageSupervisionEmployeeDto {
    private Long manageSupervisionEmployeeSeq;
    private Long toolBoxMeetingSeq;
    private Long jobSeq;
    private String manageSupervisionEmployeeNumber;
    private String employeeName;
    private String departmentCode;
    private String departmentName;
    private boolean mainBool;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public ManageSupervisionEmployeeDto(ManageSupervisionEmployeeRequest req) {
        this.manageSupervisionEmployeeSeq = req.getManageSupervisionEmployeeSeq();
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.manageSupervisionEmployeeNumber = req.getManageSupervisionEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.departmentCode = req.getDepartmentCode();
        this.departmentName = req.getDepartmentName();
        this.mainBool = req.isMainBool();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public ManageSupervisionEmployeeResponse convertManageSupervisionEmployeeResponse() {
        ManageSupervisionEmployeeResponse data = new ManageSupervisionEmployeeResponse();
        data.setManageSupervisionEmployeeSeq(this.manageSupervisionEmployeeSeq);
        data.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        data.setJobSeq(this.jobSeq);
        data.setManageSupervisionEmployeeNumber(this.manageSupervisionEmployeeNumber);
        data.setEmployeeName(this.employeeName);
        data.setDepartmentCode(this.departmentCode);
        data.setDepartmentName(this.departmentName);
        data.setMainBool(this.mainBool);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}

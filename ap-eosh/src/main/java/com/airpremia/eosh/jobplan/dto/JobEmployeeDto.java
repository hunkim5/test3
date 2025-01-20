package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.jobplan.response.JobEmployeeResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobEmployeeDto {
    private Long jobEmployeeSeq;
    private Long toolBoxMeetingSeq;
    private Long jobSeq;
    private String employeeNumber;
    private String employeeName;
    private String departmentNumber;
    private String departmentName;
    private boolean tbmBool;
    private boolean signatureCheck;
    private LocalDateTime entryDtm;
    private LocalDateTime leaveDtm;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public JobEmployeeDto(JobEmployeeRequest req) {
        this.jobEmployeeSeq = req.getJobEmployeeSeq();
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.employeeNumber = req.getEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.departmentNumber = req.getDepartmentNumber();
        this.departmentName = req.getDepartmentName();
        this.tbmBool = req.isTbmBool();
        this.signatureCheck = req.isSignatureCheck();
        this.entryDtm = req.getEntryDtm();
        this.leaveDtm = req.getLeaveDtm();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }

    public JobEmployeeResponse convertJobEmployeeResponse() {
        JobEmployeeResponse data = new JobEmployeeResponse();
        data.setJobEmployeeSeq(this.jobEmployeeSeq);
        data.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        data.setJobSeq(this.jobSeq);
        data.setEmployeeNumber(this.employeeNumber);
        data.setEmployeeName(this.employeeName);
        data.setDepartmentNumber(this.departmentNumber);
        data.setDepartmentName(this.departmentName);
        data.setTbmBool(this.tbmBool);
        data.setSignatureCheck(this.signatureCheck);
        data.setEntryDtm(this.entryDtm);
        data.setLeaveDtm(this.leaveDtm);
        data.setInsertUserId(this.insertUserId);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        data.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        return data;
    }

}

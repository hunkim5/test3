package com.airpremia.eosh.jobplan.dto;

import com.airpremia.eosh.jobplan.request.JobWalkieTalkieRequest;
import com.airpremia.eosh.jobplan.response.JobWalkieTalkieResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobWalkieTalkieDto {
    private Long jobWalkieTalkieSeq;
    private Long jobSeq;
    private String employeeNumber;
    private String employeeName;
    private String division;
    private String checkEmployeeNumber;
    private boolean checkBool;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public JobWalkieTalkieDto(JobWalkieTalkieRequest req) {
        this.jobWalkieTalkieSeq = req.getJobWalkieTalkieSeq();
        this.jobSeq = req.getJobSeq();
        this.employeeNumber = req.getEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.division = req.getDivision();
        this.checkEmployeeNumber = req.getCheckEmployeeNumber();
        this.checkBool = req.isCheckBool();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }

    public JobWalkieTalkieResponse convertJobWalkieTalkieResponse() {
        JobWalkieTalkieResponse data = new JobWalkieTalkieResponse();
        data.setJobWalkieTalkieSeq(this.jobWalkieTalkieSeq);
        data.setJobSeq(this.jobSeq);
        data.setEmployeeNumber(this.employeeNumber);
        data.setEmployeeName(this.employeeName);
        data.setDivision(this.division);
        data.setCheckEmployeeNumber(this.checkEmployeeNumber);
        data.setCheckBool(this.checkBool);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}

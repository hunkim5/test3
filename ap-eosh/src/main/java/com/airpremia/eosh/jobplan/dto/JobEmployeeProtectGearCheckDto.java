package com.airpremia.eosh.jobplan.dto;

import com.airpremia.eosh.jobplan.request.JobEmployeeProtectGearCheckRequest;
import com.airpremia.eosh.jobplan.response.JobEmployeeProtectGearCheckResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobEmployeeProtectGearCheckDto {
    private Long protectGearCheckSeq;
    private Long userProtectGearStatusSeq;
    private Long jobSeq;
    private Long jobEmployeeSeq;
    private String protectGearCode;
    private boolean checkBool;
    private String employeeNumber;
    private String employeeName;
    private int quantity;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public JobEmployeeProtectGearCheckDto(JobEmployeeProtectGearCheckRequest req) {
        this.protectGearCheckSeq = req.getProtectGearCheckSeq();
        this.jobSeq = req.getJobSeq();
        this.jobEmployeeSeq = req.getJobEmployeeSeq();
        this.protectGearCode = req.getProtectGearCode();
        this.checkBool = req.isCheckBool();
        this.employeeNumber = req.getEmployeeNumber();
        this.employeeName = req.getEmployeeName();
    }

    public JobEmployeeProtectGearCheckResponse convertJobEmployeeProtectGearCheckResponse() {
        JobEmployeeProtectGearCheckResponse data = new JobEmployeeProtectGearCheckResponse();
        data.setJobSeq(this.jobSeq);
        data.setJobEmployeeSeq(this.jobEmployeeSeq);
        data.setProtectGearCheckSeq(this.protectGearCheckSeq);
        data.setJobEmployeeSeq(this.jobEmployeeSeq);
        data.setProtectGearCode(this.protectGearCode);
        data.setCheckBool(this.checkBool);
        data.setEmployeeNumber(this.employeeNumber);
        data.setEmployeeName(this.employeeName);
        data.setQuantity(this.quantity);
        return data;
    }

    public JobEmployeeProtectGearCheckDto(Long jobSeq, Long jobEmployeeSeq, boolean checkBool) {
        this.jobSeq = jobSeq;
        this.jobEmployeeSeq = jobEmployeeSeq;
        this.checkBool = checkBool;
    }

}

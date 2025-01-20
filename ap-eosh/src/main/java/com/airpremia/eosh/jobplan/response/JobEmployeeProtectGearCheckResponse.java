package com.airpremia.eosh.jobplan.response;

import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobEmployeeProtectGearCheckResponse {
    @Schema(description = "근로자 보호구 확인 시퀀스")
    private Long protectGearCheckSeq;
    @Schema(description = "사용자 보호구 현황 시퀀스")
    private Long userProtectGearStatusSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "근로자 시퀀스")
    private Long jobEmployeeSeq;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "확인 여부")
    private boolean checkBool;
    @Schema(description = "사번")
    private String employeeNumber;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "보호구 수량")
    private int quantity;

    public JobEmployeeProtectGearCheckResponse(JobEmployeeProtectGearCheckDto req) {
        this.protectGearCheckSeq = req.getProtectGearCheckSeq();
        this.jobSeq = req.getJobSeq();
        this.jobEmployeeSeq = req.getJobEmployeeSeq();
        this.protectGearCode = req.getProtectGearCode();
        this.checkBool = req.isCheckBool();
        this.employeeNumber = req.getEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.quantity = req.getQuantity();
    }
}

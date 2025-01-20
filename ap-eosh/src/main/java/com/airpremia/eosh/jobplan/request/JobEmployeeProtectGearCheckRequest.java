package com.airpremia.eosh.jobplan.request;

import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobEmployeeProtectGearCheckRequest {
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

    public JobEmployeeProtectGearCheckDto convertJobEmployeeProtectGearCheckDto() {
        JobEmployeeProtectGearCheckDto dto = new JobEmployeeProtectGearCheckDto();
        dto.setProtectGearCheckSeq(this.protectGearCheckSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setJobEmployeeSeq(this.jobEmployeeSeq);
        dto.setProtectGearCode(this.protectGearCode);
        dto.setCheckBool(this.checkBool);
        dto.setEmployeeNumber(this.employeeNumber);
        dto.setEmployeeName(this.employeeName);
        return dto;
    }


}

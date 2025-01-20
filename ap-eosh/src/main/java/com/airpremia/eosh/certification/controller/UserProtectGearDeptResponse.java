package com.airpremia.eosh.certification.controller;

import java.time.LocalDate;

import com.airpremia.eosh.certification.dto.UserProtectGearDeptDto;
import com.airpremia.eosh.common.dto.HrEmpDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectGearDeptResponse {
    @Schema(description = "사용자 보호구 현황 시퀀스")
    private Long userProtectGearStatusSeq;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "제조날짜")
    private LocalDate manufacturingDt;
    @Schema(description = "폐기날짜")
    private LocalDate disposalDt;
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자이름")
    private String userName;
    @Schema(description = "부서명")
    private String departmentName;
    @Schema(description = "서명여부")
    private boolean signatureBool;

    public void setHrEmpInfo(HrEmpDto dto) {
        this.userId = dto.getUserId();
        this.userName = dto.getEmpNm();
        this.departmentName = dto.getDeptNm();
    }

    public void setUserUserProtectGearInfo(UserProtectGearDeptDto dto) {
        this.userProtectGearStatusSeq = dto.getUserProtectGearStatusSeq();
        this.protectGearCode = dto.getProtectGearCode();
        this.quantity = dto.getQuantity();
        this.storageDepartmentCode = dto.getStorageDepartmentCode();
        this.manufacturingDt = dto.getManufacturingDt();
        this.disposalDt = dto.getDisposalDt();
        this.signatureBool = dto.isSignatureBool();
    }
}

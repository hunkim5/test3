package com.airpremia.eosh.certification.controller;

import com.airpremia.eosh.certification.dto.ProtectGearDepartmentQuantityDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProtectGearDeptResponse {
    @Schema(description = "부서 보호구 현황 시퀀스")
    private Long deptProtectGearStatusSeq;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "보호구 수량")
    private int quantity;

    public ProtectGearDeptResponse(ProtectGearDepartmentQuantityDto dto) {
        this.deptProtectGearStatusSeq = dto.getDeptProtectGearStatusSeq();
        this.storageDepartmentCode = dto.getStorageDepartmentCode();
        this.protectGearCode = dto.getProtectGearCode();
        this.quantity = dto.getQuantity();
    }
}

package com.airpremia.eosh.certification.dto;

import com.airpremia.eosh.certification.controller.ProtectGearDeptUpdateRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProtectGearDepartmentQuantityDto {
    private Long deptProtectGearStatusSeq;
    private String storageDepartmentCode;
    private String protectGearCode;
    private int quantity;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public ProtectGearDepartmentQuantityDto(ProtectGearDeptUpdateRequest req) {
        this.deptProtectGearStatusSeq = req.getDeptProtectGearStatusSeq();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.protectGearCode = req.getProtectGearCode();
        this.quantity = req.getQuantity();
    }
}

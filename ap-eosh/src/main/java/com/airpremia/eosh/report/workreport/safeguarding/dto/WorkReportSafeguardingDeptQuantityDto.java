package com.airpremia.eosh.report.workreport.safeguarding.dto;

import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingDeptQuantityRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingDeptQuantitySearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingDeptQuantityDto {
    private Long deptProtectiondeviceStatusSeq;
    private Long deptProtectGearStatusSeq;
    private String safeguardingCode;
    private String protectGearCode;
    private String protectGearDetailCode;
    private int quantity;
    private String storageDepartmentCode;

    public WorkReportSafeguardingDeptQuantityDto(WorkReportSafeguardingDeptQuantitySearchRequest req) {
        this.storageDepartmentCode = req.getStorageDepartmentCode();
    }

    public WorkReportSafeguardingDeptQuantityDto(WorkReportSafeguardingDeptQuantityRequest req) {
        this.deptProtectiondeviceStatusSeq = req.getDeptProtectiondeviceStatusSeq();
        this.deptProtectGearStatusSeq = req.getDeptProtectGearStatusSeq();
        this.safeguardingCode = req.getSafeguardingCode();
        this.protectGearCode = req.getProtectGearCode();
        this.protectGearDetailCode = req.getProtectGearDetailCode();
        this.quantity = req.getQuantity();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
    }
}


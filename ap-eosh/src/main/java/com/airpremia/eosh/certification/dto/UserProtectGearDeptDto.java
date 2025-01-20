package com.airpremia.eosh.certification.dto;

import java.time.LocalDate;

import com.airpremia.eosh.certification.controller.UserProtectGearDeptUpdateRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProtectGearDeptDto {
    private Long userProtectGearStatusSeq;
    private String protectGearCode;
    private String protectGearDetailCode;
    private int quantity;
    private String storageDepartmentCode;
    private LocalDate manufacturingDt;
    private LocalDate disposalDt;
    private String userId;
    private boolean signatureBool;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;
    private String userName;
    private String departmentName;

    public UserProtectGearDeptDto(UserProtectGearDeptUpdateRequest req) {
        this.userProtectGearStatusSeq = req.getUserProtectGearStatusSeq();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.protectGearCode = req.getProtectGearCode();
        this.userId = req.getUserId();
        this.manufacturingDt = req.getManufacturingDt();
        this.disposalDt = req.getDisposalDt();
        this.quantity = req.getQuantity();
        this.signatureBool = req.isSignatureBool();
        this.userName = req.getUserName();
        this.departmentName = req.getDepartmentName();
    }

    public boolean checkUpdateData() {
        return this.manufacturingDt != null || this.disposalDt != null || this.quantity > 0;
    }
}

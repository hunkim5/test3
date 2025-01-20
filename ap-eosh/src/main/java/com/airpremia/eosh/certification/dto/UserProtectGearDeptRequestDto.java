package com.airpremia.eosh.certification.dto;

import com.airpremia.eosh.certification.controller.UserProtectGearDeptRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProtectGearDeptRequestDto {
    private String storageDepartmentCode;
    private String protectGearCode;

    public UserProtectGearDeptRequestDto(UserProtectGearDeptRequest req) {
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.protectGearCode = req.getProtectGearCode();
    }
}

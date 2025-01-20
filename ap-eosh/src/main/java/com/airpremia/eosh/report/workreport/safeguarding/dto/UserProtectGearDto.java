package com.airpremia.eosh.report.workreport.safeguarding.dto;

import java.time.LocalDate;

import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectGearRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectGearSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectGearDto {
    private Long userProtectGearStatusSeq;
    private String protectGearCode;
    private String protectGearDetailCode;
    private int quantity;
    private String storageDepartmentCode;
    private LocalDate manufacturingDt;
    private LocalDate disposalDt;
    private String userId;
    private boolean signatureBool;
    private String insertId;
    private String insertIp;
    private String updateId;
    private String updateIp;
    private String userName;
    private String departmentName;


    public UserProtectGearDto(UserProtectGearRequest request) {
        this.userProtectGearStatusSeq = request.getUserProtectGearStatusSeq();
        this.protectGearCode = request.getProtectGearCode();
        this.protectGearDetailCode = request.getProtectGearDetailCode();
        this.quantity = request.getQuantity();
        this.storageDepartmentCode = request.getStorageDepartmentCode();
        this.manufacturingDt = request.getManufacturingDt();
        this.disposalDt = request.getDisposalDt();
        this.userId = request.getUserId();
        this.userName = request.getUserName();
        this.departmentName = request.getDepartmentName();
        this.signatureBool = request.isSignatureBool();
    }

    public UserProtectGearDto(UserProtectGearSearchRequest request) {
        this.protectGearCode = request.getProtectGearCode();
        this.protectGearDetailCode = request.getProtectGearDetailCode();
        this.manufacturingDt = request.getManufacturingDt();
        this.disposalDt = request.getDisposalDt();
        this.signatureBool = request.isSignatureBool();
    }
}


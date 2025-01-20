package com.airpremia.eosh.report.workreport.safeguarding.dto;

import java.time.LocalDate;

import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectiondeviceRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectiondeviceSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectiondeviceDto {
    private Long userProtectiondeviceStatusSeq;
    private String safeguardingCode;
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

    public UserProtectiondeviceDto(UserProtectiondeviceRequest request) {
        this.userProtectiondeviceStatusSeq = request.getUserProtectiondeviceStatusSeq();
        this.safeguardingCode = request.getSafeguardingCode();
        this.quantity = request.getQuantity();
        this.storageDepartmentCode = request.getStorageDepartmentCode();
        this.manufacturingDt = request.getManufacturingDt();
        this.disposalDt = request.getDisposalDt();
        this.userId = request.getUserId();
        this.userName = request.getUserName();
        this.departmentName = request.getDepartmentName();
        this.signatureBool = request.isSignatureBool();
    }

    public UserProtectiondeviceDto(UserProtectiondeviceSearchRequest request) {
        this.safeguardingCode = request.getSafeguardingCode();
        this.storageDepartmentCode = request.getStorageDepartmentCode();
        this.manufacturingDt = request.getManufacturingDt();
        this.disposalDt = request.getDisposalDt();
        this.signatureBool = request.isSignatureBool();
    }
}


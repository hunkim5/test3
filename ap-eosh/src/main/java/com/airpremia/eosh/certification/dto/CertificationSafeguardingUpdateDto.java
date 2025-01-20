package com.airpremia.eosh.certification.dto;

import java.time.LocalDate;

import com.airpremia.eosh.certification.controller.CertificationSafeguardingRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CertificationSafeguardingUpdateDto {
    private Long safeguardingSeq;
    private boolean safetyCertificationBool;
    private boolean autonomySafetyCheckReportBool;
    private boolean safetyInspectionBool;
    private boolean etcBool;
    private int protectionDeviceQuantity;
    private int protectGearQuantity;
    private LocalDate expirationDt;
    private String updateUserId;
    private String updateIp;

    public CertificationSafeguardingUpdateDto(CertificationSafeguardingRequest req) {
        this.safetyCertificationBool = req.isSafetyCertificationBool();
        this.autonomySafetyCheckReportBool = req.isAutonomySafetyCheckReportBool();
        this.safetyInspectionBool = req.isSafetyInspectionBool();
        this.etcBool = req.isEtcBool();
        this.protectionDeviceQuantity = req.getProtectionDeviceQuantity();
        this.protectGearQuantity = req.getProtectGearQuantity();
        this.expirationDt = req.getExpirationDt();
    }
}

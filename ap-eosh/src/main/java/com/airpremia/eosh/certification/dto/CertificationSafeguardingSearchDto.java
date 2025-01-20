package com.airpremia.eosh.certification.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.certification.controller.CertificationSafeguardingSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CertificationSafeguardingSearchDto {
    private String safeguardingCode;
    private String protectGearCode;
    private String productName;
    private String productModelName;
    private boolean safetyCertificationBool;
    private boolean autonomySafetyCheckReportBool;
    private boolean safetyInspectionBool;
    private boolean etcBool;
    private LocalDate registrationDt;
    private LocalDate expirationDt;

    public CertificationSafeguardingSearchDto(CertificationSafeguardingSearchRequest req) {
        this.safeguardingCode = req.getSafeguardingCode();
        this.protectGearCode = req.getProtectGearCode();
        this.productName = searchValue(req.getProductName());
        this.productModelName = searchValue(req.getProductModelName());
        this.safetyCertificationBool = req.isSafetyCertificationBool();
        this.autonomySafetyCheckReportBool = req.isAutonomySafetyCheckReportBool();
        this.safetyInspectionBool = req.isSafetyInspectionBool();
        this.etcBool = req.isEtcBool();
        this.registrationDt = req.getRegistrationDt();
        this.expirationDt = req.getExpirationDt();
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }
}

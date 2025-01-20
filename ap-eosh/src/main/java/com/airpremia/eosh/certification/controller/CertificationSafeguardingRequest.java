package com.airpremia.eosh.certification.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CertificationSafeguardingRequest {
    @Schema(description = "안전 인증 여부")
    private boolean safetyCertificationBool;
    @Schema(description = "자율 안전 확인 신고 여부")
    private boolean autonomySafetyCheckReportBool;
    @Schema(description = "안전 검사 여부")
    private boolean safetyInspectionBool;
    @Schema(description = "기타 여부")
    private boolean etcBool;
    @Schema(description = "방호장치 수량")
    private int protectionDeviceQuantity;
    @Schema(description = "보호구 수량")
    private int protectGearQuantity;
    @Schema(description = "말소 일자")
    private LocalDate expirationDt;
}

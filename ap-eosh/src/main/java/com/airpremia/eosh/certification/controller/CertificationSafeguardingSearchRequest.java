package com.airpremia.eosh.certification.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CertificationSafeguardingSearchRequest {
    @Schema(description = "안전방호 코드")
    private String safeguardingCode;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "제품 이름")
    private String productName;
    @Schema(description = "제품 모델 이름")
    private String productModelName;
    @Schema(description = "안전 인증 여부")
    private boolean safetyCertificationBool;
    @Schema(description = "자율 안전 확인 신고 여부")
    private boolean autonomySafetyCheckReportBool;
    @Schema(description = "안전 검사 여부")
    private boolean safetyInspectionBool;
    @Schema(description = "기타 여부")
    private boolean etcBool;
    @Schema(description = "등록 날짜")
    private LocalDate registrationDt;
    @Schema(description = "말소 날짜")
    private LocalDate expirationDt;
}

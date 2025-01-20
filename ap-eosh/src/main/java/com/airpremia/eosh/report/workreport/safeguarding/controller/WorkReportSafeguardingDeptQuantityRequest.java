package com.airpremia.eosh.report.workreport.safeguarding.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingDeptQuantityRequest {
    @Schema(description = "부서 방호장치 현황 시퀀스")
    private Long deptProtectiondeviceStatusSeq;
    @Schema(description = "부서 보호구 현황 시퀀스")
    private Long deptProtectGearStatusSeq;
    @Schema(description = "방호장치 코드")
    private String safeguardingCode;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "보호구 세부 코드")
    private String protectGearDetailCode;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;

}


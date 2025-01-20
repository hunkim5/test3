package com.airpremia.eosh.report.workreport.safeguarding.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingDeptQuantitySearchRequest {
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
}


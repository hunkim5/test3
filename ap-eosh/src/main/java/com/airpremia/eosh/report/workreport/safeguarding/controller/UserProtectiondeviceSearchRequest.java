package com.airpremia.eosh.report.workreport.safeguarding.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectiondeviceSearchRequest {
    @Schema(description = "안전방호코드")
    private String safeguardingCode;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "제조날짜")
    private LocalDate manufacturingDt;
    @Schema(description = "폐기날짜")
    private LocalDate disposalDt;
    @Schema(description = "서명여부")
    private boolean signatureBool;

}


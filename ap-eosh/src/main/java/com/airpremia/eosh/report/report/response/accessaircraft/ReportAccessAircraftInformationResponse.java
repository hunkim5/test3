package com.airpremia.eosh.report.report.response.accessaircraft;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportAccessAircraftInformationResponse {
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "접근 항공기 정보 코드")
    private String accessAircraftInformationCode;
}

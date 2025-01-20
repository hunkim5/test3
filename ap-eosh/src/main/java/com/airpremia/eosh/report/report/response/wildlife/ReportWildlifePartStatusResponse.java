package com.airpremia.eosh.report.report.response.wildlife;

import com.airpremia.esmsfos.core.entities.ReportWildlifePartStatusEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportWildlifePartStatusResponse {
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "야생생물 항공기 부품 코드")
    private String wildlifeAircraftPartCode;
    @Schema(description = "충돌된 여부")
    private boolean struckBool = false;
    @Schema(description = "손상된 여부")
    private boolean damagedBool = false;


    public ReportWildlifePartStatusResponse(ReportWildlifePartStatusEntity reportWildlifePartStatusEntity) {
        this.reportUuid = reportWildlifePartStatusEntity.getReportUuid();
        this.wildlifeAircraftPartCode = reportWildlifePartStatusEntity.getWildlifeAircraftPartCode();
        this.struckBool = reportWildlifePartStatusEntity.isStruckBool();
        this.damagedBool = reportWildlifePartStatusEntity.isDamagedBool();
    }
}

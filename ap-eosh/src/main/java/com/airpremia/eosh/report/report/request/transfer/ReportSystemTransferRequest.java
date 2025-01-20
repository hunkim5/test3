package com.airpremia.eosh.report.report.request.transfer;

import com.airpremia.esmsfos.core.enums.OwnerSystemClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportSystemTransferRequest {
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "복사 보고서 UUID")
    private String copyReportUuid;
    @Schema(description = "이관 대상 시스템 ENUM")
    private OwnerSystemClassificationEnum targetSystemClassificationEnum;
    @Schema(description = "보고서 이관 사유")
    private String reportTransferContent;
}

package com.airpremia.eosh.issue.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "ISSUE 발행원 Enum")
public enum IssueTargetEnum {
    REPORT, REPORT_RISK_EVALUATION, RISK_EVALUATION_CONCLUSION;

    public boolean isReport() {
        return this == REPORT;
    }

}

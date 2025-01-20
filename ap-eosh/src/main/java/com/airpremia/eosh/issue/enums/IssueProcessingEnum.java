package com.airpremia.eosh.issue.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Issue 진행상태 Enum")
public enum IssueProcessingEnum {
    OPEN, ISSUE, CLASSIFICATION, ANALYSIS1, ANALYSIS2, MITIGATION, FEEDBACK, CLOSE;
}

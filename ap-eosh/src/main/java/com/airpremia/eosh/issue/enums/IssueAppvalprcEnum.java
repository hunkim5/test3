package com.airpremia.eosh.issue.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Issue 승인상태 ENUM")
@Getter
public enum IssueAppvalprcEnum {
    OPEN, REPORT_CLOSE, REPORT_REJECT, DRAFT, FINAL_CLOSE, CLOSE;

    public boolean isDraft() {
        return this == DRAFT;
    }

    public boolean isDifferentFrom(IssueAppvalprcEnum otherApproval) {
        return !this.equals(otherApproval);
    }

}

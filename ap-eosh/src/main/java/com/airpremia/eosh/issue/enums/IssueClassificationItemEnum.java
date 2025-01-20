package com.airpremia.eosh.issue.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "ISSUE이 코드성 ITEM 분류 ENUM")
public enum IssueClassificationItemEnum {
    DAMAGED_PROPERTY_CODE, ISSUE_EVENT_CATEGORY_CODE, NATURE_INJURY_CODE, LOCATION_INJURY_CODE, ROOT_CAUSE_ANALYSIS_CODE
}

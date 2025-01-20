package com.airpremia.eosh.issue.dto.issue;

import java.util.List;

import com.airpremia.eosh.issue.enums.IssueProcessingEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainToReportMappingDto {
    private String mainReportUuid;
    private boolean organizationAlarmBool;
    private IssueProcessingEnum issueProcessingEnum;
    private List<String> relateReportUuidList;
}

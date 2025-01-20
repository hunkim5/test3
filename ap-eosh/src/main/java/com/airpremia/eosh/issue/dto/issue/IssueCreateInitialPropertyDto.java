package com.airpremia.eosh.issue.dto.issue;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IssueCreateInitialPropertyDto {
    private Integer likelihoodLevel;
    private String sourceId;
    private String reportUuid;
    private LocalDateTime reportInsertDtm;
    private String issueSubject;
}

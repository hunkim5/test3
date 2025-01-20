package com.airpremia.eosh.issue.dto.relatereport;

import java.time.LocalDateTime;

import com.airpremia.esmsfos.core.enums.ReportClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class IssueRelateReportDto {
    private Long issueSeq;
    private String reportUuid;
    private String reportId;
    private String reportSubject;
    private LocalDateTime reportEventDtm;
    private boolean issueBool;
    private boolean investigationBool;
    private String reportUserNm;
    private LocalDateTime reportDtm;
    private String reportEtcCode;
    private ReportClassificationEnum reportClassificationEnum;
    private LocalDateTime reportInsertDtm;

}

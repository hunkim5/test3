package com.airpremia.eosh.report.report.request.issue;


import java.time.LocalDateTime;

import com.airpremia.eosh.issue.dto.issue.IssueCreateInitialPropertyDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportIssueRequest {
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "ISSUE 여부")
    private Boolean issueBool;
    @Schema(description = "보고서 제목")
    private String reportSubject;
    @Schema(description = "보고서 ID")
    private String reportId;
    @Schema(description = "발생가능성 수준")
    private Integer likelihoodLevel;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;

    public IssueCreateInitialPropertyDto toIssueCreateDto() {
        IssueCreateInitialPropertyDto issueCreateDto = new IssueCreateInitialPropertyDto();

        issueCreateDto.setReportUuid(this.reportUuid);
        issueCreateDto.setIssueSubject(this.reportSubject);
        issueCreateDto.setSourceId(this.reportId);
        issueCreateDto.setLikelihoodLevel(this.likelihoodLevel);
        issueCreateDto.setReportInsertDtm(this.insertDtm);

        return issueCreateDto;
    }
}

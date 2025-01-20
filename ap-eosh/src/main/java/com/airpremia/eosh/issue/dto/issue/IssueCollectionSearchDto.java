package com.airpremia.eosh.issue.dto.issue;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IssueCollectionSearchDto {
    private String sourceClassification;
    private LocalDateTime searchFromReportInsertDtm;
    private LocalDateTime searchToReportInsertDtm;
    private String issueSubject;

    public void setSearchFromReportInsertDtm(LocalDateTime searchFromReportInsertDtm) {
        if (searchFromReportInsertDtm != null) {
            this.searchFromReportInsertDtm = searchFromReportInsertDtm.toLocalDate().atStartOfDay();
        } else {
            this.searchFromReportInsertDtm = null;
        }
    }

    public void setSearchToReportInsertDtm(LocalDateTime searchToReportInsertDtm) {
        if (searchToReportInsertDtm != null) {
            this.searchToReportInsertDtm = searchToReportInsertDtm.toLocalDate().plusDays(1).atStartOfDay();
        } else {
            this.searchToReportInsertDtm = null;
        }
    }
}

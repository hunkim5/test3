package com.airpremia.eosh.report.workreport.workreportconstruction.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionSearchRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkConstructionClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportConstructionPageDto {

    private Long workReportConstructionSeq;

    private String reportNo;

    private String workReportSubject;

    private WorkConstructionClassificationEnum workConstructionClassificationEnum;

    private LocalDate workExpectDt;

    private String performCompanyName;

    private String performInchargePhoneno;

    private String sourceAddress;

    private String targetAddress;

    private String maintenanceContent;

    private String inchargeUserId;

    private String inchargeDepartmentId;

    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;

    private String multipleFileUuid;

    private LocalDateTime insertDtm;

    public WorkReportConstructionPageDto(WorkReportConstructionSearchRequest req) {
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeUserId = req.getInchargeUserId();
        this.maintenanceContent = req.getMaintenanceContent();
        this.performCompanyName = req.getPerformCompanyName();
        this.performInchargePhoneno = req.getPerformInchargePhoneno();
        this.sourceAddress = searchValue(req.getSourceAddress());
        this.targetAddress = searchValue(req.getTargetAddress());
        this.workConstructionClassificationEnum = req.getWorkConstructionClassificationEnum();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.workExpectDt = req.getWorkExpectDt();
        this.workReportSubject = searchValue(req.getWorkReportSubject());
        this.reportNo = searchValue(req.getReportNo());
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }
}


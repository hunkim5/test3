package com.airpremia.eosh.report.workreport.workreportconstruction.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionResponse;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkConstructionClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportConstructionDto {

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

    private String rejectReason;

    private String insertIp;

    private String insertUserId;

    private String updateUserId;

    private String updateIp;


    public WorkReportConstructionDto(WorkReportConstructionRequest req) {
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeUserId = req.getInchargeUserId();
        this.maintenanceContent = req.getMaintenanceContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.performCompanyName = req.getPerformCompanyName();
        this.performInchargePhoneno = req.getPerformInchargePhoneno();
        this.sourceAddress = req.getSourceAddress();
        this.targetAddress = req.getTargetAddress();
        this.workConstructionClassificationEnum = req.getWorkConstructionClassificationEnum();
        this.workExpectDt = req.getWorkExpectDt();
        this.workReportConstructionSeq = req.getWorkReportConstructionSeq();
        this.workReportSubject = req.getWorkReportSubject();
        this.rejectReason = req.getRejectReason();
    }

    public WorkReportConstructionResponse convertWorkReportConstructionResponse() {
        WorkReportConstructionResponse res = new WorkReportConstructionResponse();
        res.setApprovalWorkReportStatusEnum(this.approvalWorkReportStatusEnum);
        res.setInchargeDepartmentId(this.inchargeDepartmentId);
        res.setInchargeUserId(this.inchargeUserId);
        res.setMaintenanceContent(this.maintenanceContent);
        res.setMultipleFileUuid(this.multipleFileUuid);
        res.setPerformCompanyName(this.performCompanyName);
        res.setPerformInchargePhoneno(this.performInchargePhoneno);
        res.setSourceAddress(this.sourceAddress);
        res.setTargetAddress(this.targetAddress);
        res.setWorkConstructionClassificationEnum(this.workConstructionClassificationEnum);
        res.setWorkExpectDt(this.workExpectDt);
        res.setWorkReportConstructionSeq(this.workReportConstructionSeq);
        res.setWorkReportSubject(this.workReportSubject);
        res.setReportNo(this.reportNo);
        res.setRejectReason(this.rejectReason);
        return res;
    }
}


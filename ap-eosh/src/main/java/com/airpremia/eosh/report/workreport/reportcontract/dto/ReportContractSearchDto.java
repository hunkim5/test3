package com.airpremia.eosh.report.workreport.reportcontract.dto;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractSearchRequest;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReportContractSearchDto {
    private Long contractSeq;
    private String reportNo;
    private String contractInchargeDepartmentCode;
    private String contractInchargeDepartmentName;
    private String contractInchargeId;
    private String contractInchargeName;
    private String contractCompanyName;
    private String contractCompanyInchargeName;
    private String contractCompanyContact;
    private String contractCompanyEmail;
    private String contractPhaseCode;
    private int topCompanyOneOrder;
    private int topCompanyTwoOrder;
    private int topCompanyThreeOrder;
    private CompanyGradeEnum companyGradeEnum;
    private String partnerCompanyWorkplaceCode;
    private String partnerCompanyWorkplaceText;
    private boolean managementWorkplaceBool;
    private String partnerMajorWork;
    private boolean subcontractingBool;
    private String subcontractingCompanyName;
    private String addComment;
    private String attachMultipleFileUuid;
    private String feedbackContent;
    private String rejectReason;
    private boolean safetyActionTargetBool;
    private boolean safetyHealthConsultativeGroupBool;
    private boolean safetyHealthCheckBool;
    private boolean evaluationTargetBool;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private boolean job60DayBool;
    private boolean deliveryBool;
    private boolean installationMaintenanceBool;
    private boolean enterCompanyBool;
    private boolean routineInspectionBool;
    private boolean notApplicableBool;
    private boolean judgmentBool;
    private String partnerCompanyInchargeName;

    public ReportContractSearchDto(ReportContractSearchRequest req) {
        this.contractSeq = req.getContractSeq();
        this.reportNo = req.getReportNo();
        this.contractInchargeDepartmentCode = req.getContractInchargeDepartmentCode();
        this.contractInchargeDepartmentName = req.getContractInchargeDepartmentName();
        this.contractInchargeId = req.getContractInchargeId();
        this.contractInchargeName = req.getContractInchargeName();
        this.contractCompanyName = searchValue(req.getContractCompanyName());
        this.contractCompanyInchargeName = searchValue(req.getContractCompanyInchargeName());
        this.contractCompanyContact = searchValue(req.getContractCompanyContact());
        this.contractCompanyEmail = searchValue(req.getContractCompanyEmail());
        this.contractPhaseCode = req.getContractPhaseCode();
        this.topCompanyOneOrder = req.getTopCompanyOneOrder();
        this.topCompanyTwoOrder = req.getTopCompanyTwoOrder();
        this.topCompanyThreeOrder = req.getTopCompanyThreeOrder();
        this.companyGradeEnum = req.getCompanyGradeEnum();
        this.partnerCompanyWorkplaceCode = req.getPartnerCompanyWorkplaceCode();
        this.partnerCompanyWorkplaceText = req.getPartnerCompanyWorkplaceText();
        this.managementWorkplaceBool = req.isManagementWorkplaceBool();
        this.partnerMajorWork = req.getPartnerMajorWork();
        this.subcontractingBool = req.isSubcontractingBool();
        this.subcontractingCompanyName = req.getSubcontractingCompanyName();
        this.addComment = req.getAddComment();
        this.attachMultipleFileUuid = req.getAttachMultipleFileUuid();
        this.feedbackContent = req.getFeedbackContent();
        this.rejectReason = req.getRejectReason();
        this.safetyActionTargetBool = req.isSafetyActionTargetBool();
        this.safetyHealthConsultativeGroupBool = req.isSafetyHealthConsultativeGroupBool();
        this.safetyHealthCheckBool = req.isSafetyHealthCheckBool();
        this.evaluationTargetBool = req.isEvaluationTargetBool();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.job60DayBool = req.isJob60DayBool();
        this.deliveryBool = req.isDeliveryBool();
        this.installationMaintenanceBool = req.isInstallationMaintenanceBool();
        this.enterCompanyBool = req.isEnterCompanyBool();
        this.routineInspectionBool = req.isRoutineInspectionBool();
        this.notApplicableBool = req.isNotApplicableBool();
        this.judgmentBool = req.isJudgmentBool();
        this.partnerCompanyInchargeName = req.getPartnerCompanyInchargeName();
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }

}


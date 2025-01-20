package com.airpremia.eosh.report.workreport.reportcontract.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractRequest;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractResponse;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReportContractDto {
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
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public ReportContractDto(ReportContractRequest req) {
        this.contractSeq = req.getContractSeq();
        this.reportNo = req.getReportNo();
        this.contractInchargeDepartmentCode = req.getContractInchargeDepartmentCode();
        this.contractInchargeDepartmentName = req.getContractInchargeDepartmentName();
        this.contractInchargeId = req.getContractInchargeId();
        this.contractInchargeName = req.getContractInchargeName();
        this.contractCompanyName = req.getContractCompanyName();
        this.contractCompanyInchargeName = req.getContractCompanyInchargeName();
        this.contractCompanyContact = req.getContractCompanyContact();
        this.contractCompanyEmail = req.getContractCompanyEmail();
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

    public ReportContractResponse convertReportContractResponse() {
        ReportContractResponse data = new ReportContractResponse();
        data.setContractSeq(this.contractSeq);
        data.setReportNo(this.reportNo);
        data.setContractInchargeDepartmentCode(this.contractInchargeDepartmentCode);
        data.setContractInchargeDepartmentName(this.contractInchargeDepartmentName);
        data.setContractInchargeId(this.contractInchargeId);
        data.setContractInchargeName(this.contractInchargeName);
        data.setContractCompanyName(this.contractCompanyName);
        data.setContractCompanyInchargeName(this.contractCompanyInchargeName);
        data.setContractCompanyContact(this.contractCompanyContact);
        data.setContractCompanyEmail(this.contractCompanyEmail);
        data.setContractPhaseCode(this.contractPhaseCode);
        data.setTopCompanyOneOrder(this.topCompanyOneOrder);
        data.setTopCompanyTwoOrder(this.topCompanyTwoOrder);
        data.setTopCompanyThreeOrder(this.topCompanyThreeOrder);
        data.setCompanyGradeEnum(this.companyGradeEnum);
        data.setPartnerCompanyWorkplaceCode(this.partnerCompanyWorkplaceCode);
        data.setPartnerCompanyWorkplaceText(this.partnerCompanyWorkplaceText);
        data.setManagementWorkplaceBool(this.managementWorkplaceBool);
        data.setPartnerMajorWork(this.partnerMajorWork);
        data.setSubcontractingBool(this.subcontractingBool);
        data.setSubcontractingCompanyName(this.subcontractingCompanyName);
        data.setAddComment(this.addComment);
        data.setAttachMultipleFileUuid(this.attachMultipleFileUuid);
        data.setFeedbackContent(this.feedbackContent);
        data.setRejectReason(this.rejectReason);
        data.setSafetyActionTargetBool(this.safetyActionTargetBool);
        data.setSafetyHealthConsultativeGroupBool(this.safetyHealthConsultativeGroupBool);
        data.setSafetyHealthCheckBool(this.safetyHealthCheckBool);
        data.setEvaluationTargetBool(this.evaluationTargetBool);
        data.setApprovalWorkReportStatusEnum(this.approvalWorkReportStatusEnum);
        data.setJob60DayBool(this.job60DayBool);
        data.setDeliveryBool(this.deliveryBool);
        data.setInstallationMaintenanceBool(this.installationMaintenanceBool);
        data.setEnterCompanyBool(this.enterCompanyBool);
        data.setRoutineInspectionBool(this.routineInspectionBool);
        data.setNotApplicableBool(this.notApplicableBool);
        data.setJudgmentBool(this.judgmentBool);
        data.setPartnerCompanyInchargeName(this.partnerCompanyInchargeName);
        data.setInsertDtm(this.insertDtm);
        return data;
    }
}


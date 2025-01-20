package com.airpremia.eosh.report.workreport.reportcontract.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReportContractPageDto {
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
}


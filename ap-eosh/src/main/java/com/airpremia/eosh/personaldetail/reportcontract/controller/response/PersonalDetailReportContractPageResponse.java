package com.airpremia.eosh.personaldetail.reportcontract.controller.response;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractPageDto;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractPageResponse {

    private Long contractSeq;
    private String contractCompanyName;
    private String contractCompanyInchargeName;
    private String contractCompanyContact;
    private String contractCompanyEmail;
    private CompanyGradeEnum companyGradeEnum;
    private Boolean safetyActionTargetBool;
    private Boolean safetyHealthConsultativeGroupBool;
    private Boolean safetyHealthCheckBool;
    private Boolean evaluationTargetBool;
    private String contractDepartmentName;
    private String contractInchargeId;
    private String contractInchargeName;
    private String contractInchargeDepartmentName;
    private String contractInchargeDepartmentCode;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;

    public PersonalDetailReportContractPageResponse(PersonalDetailReportContractPageDto dto) {
        this.contractSeq = dto.getContractSeq();
        this.contractCompanyName = dto.getContractCompanyName();
        this.contractCompanyInchargeName = dto.getContractCompanyInchargeName();
        this.contractCompanyContact = dto.getContractCompanyContact();
        this.contractCompanyEmail = dto.getContractCompanyEmail();
        this.companyGradeEnum = dto.getCompanyGradeEnum();
        this.safetyActionTargetBool = dto.getSafetyActionTargetBool();
        this.safetyHealthConsultativeGroupBool = dto.getSafetyHealthConsultativeGroupBool();
        this.safetyHealthCheckBool = dto.getSafetyHealthCheckBool();
        this.evaluationTargetBool = dto.getEvaluationTargetBool();
        this.contractDepartmentName = dto.getContractDepartmentName();
        this.contractInchargeId = dto.getContractInchargeId();
        this.contractInchargeName = dto.getContractInchargeName();
        this.contractInchargeDepartmentCode = dto.getContractInchargeDepartmentCode();
        this.contractInchargeDepartmentName = dto.getContractInchargeDepartmentName();
        this.approvalWorkReportStatusEnum = dto.getApprovalWorkReportStatusEnum();
    }
}


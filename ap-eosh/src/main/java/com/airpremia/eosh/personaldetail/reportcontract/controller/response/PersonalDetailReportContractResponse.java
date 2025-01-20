package com.airpremia.eosh.personaldetail.reportcontract.controller.response;

import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractDto;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractResponse {
    private Long contractSeq;
    private String contractCompanyName;
    private String contractCompanyInchargeName;
    private String contractCompanyContact;
    private String contractCompanyEmail;
    private CompanyGradeEnum companyGradeEnum;
    private String topCompanyOneOrder;
    private String topCompanyTwoOrder;
    private String topCompanyThreeOrder;
    private Boolean safetyActionTargetBool;
    private Boolean safetyHealthConsultativeGroupBool;
    private Boolean safetyHealthCheckBool;
    private Boolean evaluationTargetBool;
    private String contractInchargeDepartmentCode;
    private String contractInchargeDepartmentName;
    private String contractInchargeId;
    private String contractInchargeName;
    private String reportNo;
    private String attachMultipleFileUuid;

    public PersonalDetailReportContractResponse(PersonalDetailReportContractDto dto) {
        this.contractSeq = dto.getContractSeq();
        this.contractCompanyName = dto.getContractCompanyName();
        this.contractCompanyInchargeName = dto.getContractCompanyInchargeName();
        this.contractCompanyContact = dto.getContractCompanyContact();
        this.contractCompanyEmail = dto.getContractCompanyEmail();
        this.companyGradeEnum = dto.getCompanyGradeEnum();
        this.topCompanyOneOrder = String.valueOf(dto.getTopCompanyOneOrder());
        this.topCompanyTwoOrder = String.valueOf(dto.getTopCompanyTwoOrder());
        this.topCompanyThreeOrder = String.valueOf(dto.getTopCompanyThreeOrder());
        this.safetyActionTargetBool = dto.getSafetyActionTargetBool();
        this.safetyHealthConsultativeGroupBool = dto.getSafetyHealthConsultativeGroupBool();
        this.safetyHealthCheckBool = dto.getSafetyHealthCheckBool();
        this.evaluationTargetBool = dto.getEvaluationTargetBool();
        this.contractInchargeDepartmentCode = dto.getContractInchargeDepartmentCode();
        this.contractInchargeDepartmentName = dto.getContractInchargeDepartmentName();
        this.contractInchargeId = dto.getContractInchargeId();
        this.contractInchargeName = dto.getContractInchargeName();
        this.reportNo = dto.getReportNo();
        this.attachMultipleFileUuid = dto.getAttachMultipleFileUuid();
    }
}


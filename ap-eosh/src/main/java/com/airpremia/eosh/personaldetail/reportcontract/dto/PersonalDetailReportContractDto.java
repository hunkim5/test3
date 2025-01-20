package com.airpremia.eosh.personaldetail.reportcontract.dto;

import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractRequest;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractDto {
    private Long contractSeq;
    private String contractCompanyName;
    private String contractCompanyInchargeName;
    private String contractCompanyContact;
    private String contractCompanyEmail;
    private CompanyGradeEnum companyGradeEnum;
    private Integer topCompanyOneOrder;
    private Integer topCompanyTwoOrder;
    private Integer topCompanyThreeOrder;
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


    public PersonalDetailReportContractDto(PersonalDetailReportContractRequest request) {
        this.contractSeq = request.getContractSeq();
        this.contractCompanyName = request.getContractCompanyName();
        this.contractCompanyInchargeName = request.getContractCompanyInchargeName();
        this.contractCompanyContact = request.getContractCompanyContact();
        this.contractCompanyEmail = request.getContractCompanyEmail();
        this.companyGradeEnum = request.getCompanyGradeEnum();
        this.topCompanyOneOrder = request.getTopCompanyOneOrder();
        this.topCompanyTwoOrder = request.getTopCompanyTwoOrder();
        this.topCompanyThreeOrder = request.getTopCompanyThreeOrder();
        this.safetyActionTargetBool = request.getSafetyActionTargetBool();
        this.safetyHealthConsultativeGroupBool = request.getSafetyHealthConsultativeGroupBool();
        this.safetyHealthCheckBool = request.getSafetyHealthCheckBool();
        this.evaluationTargetBool = request.getEvaluationTargetBool();
        this.contractInchargeDepartmentCode = request.getContractInchargeDepartmentCode();
        this.contractInchargeDepartmentName = request.getContractInchargeDepartmentName();
        this.contractInchargeId = request.getContractInchargeId();
        this.attachMultipleFileUuid = request.getAttachMultipleFileUuid();

    }
}


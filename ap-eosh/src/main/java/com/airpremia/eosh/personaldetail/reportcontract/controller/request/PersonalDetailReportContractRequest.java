package com.airpremia.eosh.personaldetail.reportcontract.controller.request;


import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractRequest {
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
    private String attachMultipleFileUuid;
}


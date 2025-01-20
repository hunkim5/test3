package com.airpremia.eosh.personaldetail.reportcontract.dto;


import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractPageDto {

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

}


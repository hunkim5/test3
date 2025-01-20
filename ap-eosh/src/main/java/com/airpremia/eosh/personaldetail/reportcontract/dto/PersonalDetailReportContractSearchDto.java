package com.airpremia.eosh.personaldetail.reportcontract.dto;


import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractSearchRequest;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractSearchDto {

    private CompanyGradeEnum companyGradeEnum;
    private String contractInchargeName;
    private String contractInchargeId;
    private String contractInchargeDepartmentName;
    private String contractInchargeDepartmentCode;

    public PersonalDetailReportContractSearchDto(PersonalDetailReportContractSearchRequest request) {
        this.companyGradeEnum = request.getCompanyGradeEnum();
        this.contractInchargeName = request.getContractInchargeName();
        this.contractInchargeId = request.getContractInchargeId();
        this.contractInchargeDepartmentName = request.getContractInchargeDepartmentName();
        this.contractInchargeDepartmentCode = request.getContractInchargeDepartmentCode();
    }

}


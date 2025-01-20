package com.airpremia.eosh.personaldetail.reportcontract.controller.request;


import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailReportContractSearchRequest {

    @Schema(description = "업체 등급 ENUM")
    private CompanyGradeEnum companyGradeEnum;
    @Schema(description = "계약 담당 이름")
    private String contractInchargeName;
    @Schema(description = "계약 담당 아이디")
    private String contractInchargeId;
    @Schema(description = "계약 담당 부서 이름")
    private String contractInchargeDepartmentName;
    @Schema(description = "계약 담당 부서 아이디")
    private String contractInchargeDepartmentCode;
}


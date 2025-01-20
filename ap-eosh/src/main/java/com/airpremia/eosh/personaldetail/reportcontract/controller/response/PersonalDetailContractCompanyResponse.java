package com.airpremia.eosh.personaldetail.reportcontract.controller.response;

import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailContractCompanyDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonalDetailContractCompanyResponse {
    private Long contractSeq;
    private String contractCompanyName;

    public PersonalDetailContractCompanyResponse(PersonalDetailContractCompanyDto dto) {
        this.contractSeq = dto.getContractSeq();
        this.contractCompanyName = dto.getContractCompanyName();
    }
}


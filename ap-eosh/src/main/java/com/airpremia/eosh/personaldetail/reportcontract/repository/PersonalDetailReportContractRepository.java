package com.airpremia.eosh.personaldetail.reportcontract.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailContractCompanyDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractPageDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractSearchDto;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;


@Repository
public interface PersonalDetailReportContractRepository {

    Page<PersonalDetailReportContractPageDto> selectReportContractPage(
        @Param(value = "searchDto") PersonalDetailReportContractSearchDto dto, Pageable pageable);

    PersonalDetailReportContractDto selectReportContract(Long contractSeq);

    List<PersonalDetailContractCompanyDto> selectContractCompany(CompanyGradeEnum companyGradeEnum);

    void updateReportContract(PersonalDetailReportContractDto dto);

}

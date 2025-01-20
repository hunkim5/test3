package com.airpremia.eosh.report.workreport.reportcontract.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractDto;
import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractPageDto;
import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractSearchDto;


@Repository
public interface ReportContractRepository {

    int insertReportContract(ReportContractDto insertDto);

    int updateReportContract(ReportContractDto updateDto);

    int updateReportContractStatus(ReportContractDto updateDto);

    int deleteReportContract(Long contractSeq);

    Page<ReportContractPageDto> selectReportContractPage(
        @Param(value = "searchDto") ReportContractSearchDto dto, Pageable pageable);

    ReportContractDto selectReportContract(Long contractSeq);

    List<String> selectContractReportCount(String searchReportNumber);
}

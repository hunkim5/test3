package com.airpremia.eosh.report.workreport.reportcontract.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractPageResponse;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractRequest;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractResponse;
import com.airpremia.eosh.report.workreport.reportcontract.controller.ReportContractSearchRequest;
import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractDto;
import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractPageDto;
import com.airpremia.eosh.report.workreport.reportcontract.dto.ReportContractSearchDto;
import com.airpremia.eosh.report.workreport.reportcontract.repository.ReportContractRepository;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkReportClassificationEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportContractService {

    private final ReportContractRepository reportContractRepository;
    private final CommonFunction commonFunction;

    public Page<ReportContractPageResponse> selectReportContractPage(
        ReportContractSearchRequest workReportSafeguardingSearchRequest, Pageable pageable) {

        ReportContractSearchDto dto =
            new ReportContractSearchDto(workReportSafeguardingSearchRequest);
        Page<ReportContractPageDto> pageDto =
            reportContractRepository.selectReportContractPage(dto, pageable);

        return pageDto.map(ReportContractPageResponse::new);
    }

    public ReportContractResponse selectReportContract(
        Long workReportEquipmentDisassemblySeq) {
        ReportContractDto dto =
            reportContractRepository.selectReportContract(
                workReportEquipmentDisassemblySeq);
        if (dto == null) {
            dto = new ReportContractDto();
        }
        return dto.convertReportContractResponse();
    }

    public int updateReportContract(ReportContractRequest req) {
        ReportContractDto dto = new ReportContractDto(req);
        return reportContractRepository.updateReportContract(dto);
    }

    public int insertReportContract(ReportContractRequest req) {
        ReportContractDto dto = new ReportContractDto(req);
        dto.setReportNo(makeWorkReportNo());
        return reportContractRepository.insertReportContract(dto);
    }

    public int deleteReportContract(Long workReportEquipmentDisassemblySeq) {
        return reportContractRepository.deleteReportContract(
            workReportEquipmentDisassemblySeq);
    }

    public int updateReportContractStatus(ReportContractRequest req) {
        ReportContractDto dto = new ReportContractDto(req);
        return reportContractRepository.updateReportContractStatus(dto);
    }

    public String makeWorkReportNo() {
        LocalDate date = LocalDate.now();
        StringBuilder reportNumber = new StringBuilder();

        reportNumber.append(WorkReportClassificationEnum.CONTRACT.value()).append("-").append(date.getYear()).append("-").append(date.getMonthValue());

        String searchReportNumber = reportNumber.toString().concat("%");
        List<String> reportNoList = reportContractRepository.selectContractReportCount(searchReportNumber);

        int reportCount = 0;
        if (!reportNoList.isEmpty()) {
            String reportNo = reportNoList.get(0);
            reportCount = Integer.parseInt(reportNo.substring(reportNo.length() - 4), 10);
        }

        return reportNumber.append("-").append(String.format("%04d", reportCount + 1)).toString();
    }
}

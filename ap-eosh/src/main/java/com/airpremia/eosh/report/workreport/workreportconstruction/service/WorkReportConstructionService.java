package com.airpremia.eosh.report.workreport.workreportconstruction.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionPageResponse;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionResponse;
import com.airpremia.eosh.report.workreport.workreportconstruction.controller.WorkReportConstructionSearchRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.dto.WorkReportConstructionDto;
import com.airpremia.eosh.report.workreport.workreportconstruction.dto.WorkReportConstructionPageDto;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkReportClassificationEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.repository.WorkReportConstructionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkReportConstructionService {

    private final WorkReportConstructionRepository workReportConstructionRepository;

    public Page<WorkReportConstructionPageResponse> selectWorkReportConstructionPage(
        WorkReportConstructionSearchRequest req, Pageable pageable) {

        WorkReportConstructionPageDto dto = new WorkReportConstructionPageDto(req);
        Page<WorkReportConstructionPageDto> pageDto =
            workReportConstructionRepository.selectWorkReportConstructionPage(dto, pageable);

        return pageDto.map(WorkReportConstructionPageResponse::new);
    }

    public WorkReportConstructionResponse selectWorkReportConstruction(Long workReportConstructionSeq) {
        WorkReportConstructionDto dto =
            workReportConstructionRepository.selectWorkReportConstruction(workReportConstructionSeq);
        if (dto == null) {
            dto = new WorkReportConstructionDto();
        }
        return dto.convertWorkReportConstructionResponse();
    }

    public int updateWorkReportConstruction(WorkReportConstructionRequest req) {
        WorkReportConstructionDto dto = new WorkReportConstructionDto(req);
        return workReportConstructionRepository.updateWorkReportConstruction(dto);
    }

    public int insertWorkReportConstruction(WorkReportConstructionRequest req) {
        WorkReportConstructionDto dto = new WorkReportConstructionDto(req);

        dto.setReportNo(makeWorkReportNo());

        return workReportConstructionRepository.insertWorkReportConstruction(dto);
    }

    public int deleteWorkReportConstruction(Long workReportConstructionSeq) {
        return workReportConstructionRepository.deleteWorkReportConstruction(workReportConstructionSeq);
    }

    public int updateWorkReportConstructionStatus(WorkReportConstructionRequest req) {
        WorkReportConstructionDto dto = new WorkReportConstructionDto(req);
        return workReportConstructionRepository.updateWorkReportConstructionStatus(dto);
    }

    public String makeWorkReportNo() {
        LocalDate date = LocalDate.now();
        StringBuilder reportNumber = new StringBuilder();

        reportNumber.append(WorkReportClassificationEnum.CONSTRUCT.value()).append("-").append(date.getYear()).append("-").append(date.getMonthValue());

        String searchReportNumber = reportNumber.toString().concat("%");
        List<String> reportNoList = workReportConstructionRepository.selectConstructionReportCount(searchReportNumber);

        int reportCount = 0;
        if (!reportNoList.isEmpty()) {
            String reportNo = reportNoList.get(0);
            reportCount = Integer.parseInt(reportNo.substring(reportNo.length() - 4), 10);
        }

        return reportNumber.append("-").append(String.format("%04d", reportCount + 1)).toString();
    }
}

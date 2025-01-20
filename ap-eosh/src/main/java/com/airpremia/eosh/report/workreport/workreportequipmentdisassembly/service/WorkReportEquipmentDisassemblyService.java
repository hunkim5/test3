package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkReportClassificationEnum;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblyPageResponse;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblyRequest;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblyResponse;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblySearchRequest;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblyDto;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblyPageDto;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblySearchDto;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.repository.WorkReportEquipmentDisassemblyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkReportEquipmentDisassemblyService {

    private final WorkReportEquipmentDisassemblyRepository workReportEquipmentDisassemblyRepository;

    public Page<WorkReportEquipmentDisassemblyPageResponse> selectWorkReportEquipmentDisassemblyPage(
        WorkReportEquipmentDisassemblySearchRequest workReportEquipmentDisassemblySearchRequest, Pageable pageable) {

        WorkReportEquipmentDisassemblySearchDto dto =
            new WorkReportEquipmentDisassemblySearchDto(workReportEquipmentDisassemblySearchRequest);
        Page<WorkReportEquipmentDisassemblyPageDto> pageDto =
            workReportEquipmentDisassemblyRepository.selectWorkReportEquipmentDisassemblyPage(dto, pageable);

        return pageDto.map(WorkReportEquipmentDisassemblyPageResponse::new);
    }

    public WorkReportEquipmentDisassemblyResponse selectWorkReportEquipmentDisassembly(
        Long workReportEquipmentDisassemblySeq) {
        WorkReportEquipmentDisassemblyDto dto =
            workReportEquipmentDisassemblyRepository.selectWorkReportEquipmentDisassembly(
                workReportEquipmentDisassemblySeq);
        if (dto == null) {
            dto = new WorkReportEquipmentDisassemblyDto();
        }
        return dto.convertWorkReportEquipmentDisassemblyResponse();
    }

    public int updateWorkReportEquipmentDisassembly(WorkReportEquipmentDisassemblyRequest req) {
        WorkReportEquipmentDisassemblyDto dto = new WorkReportEquipmentDisassemblyDto(req);
        return workReportEquipmentDisassemblyRepository.updateWorkReportEquipmentDisassembly(dto);
    }

    public int insertWorkReportEquipmentDisassembly(WorkReportEquipmentDisassemblyRequest req) {
        WorkReportEquipmentDisassemblyDto dto = new WorkReportEquipmentDisassemblyDto(req);
        dto.setReportNo(makeWorkReportNo());
        return workReportEquipmentDisassemblyRepository.insertWorkReportEquipmentDisassembly(dto);
    }

    public int deleteWorkReportEquipmentDisassembly(Long workReportEquipmentDisassemblySeq) {
        return workReportEquipmentDisassemblyRepository.deleteWorkReportEquipmentDisassembly(
            workReportEquipmentDisassemblySeq);
    }

    public int updateWorkReportEquipmentDisassemblyStatus(WorkReportEquipmentDisassemblyRequest req) {
        WorkReportEquipmentDisassemblyDto dto = new WorkReportEquipmentDisassemblyDto(req);
        return workReportEquipmentDisassemblyRepository.updateWorkReportEquipmentDisassemblyStatus(dto);
    }

    public String makeWorkReportNo() {
        LocalDate date = LocalDate.now();
        StringBuilder reportNumber = new StringBuilder();

        reportNumber.append(WorkReportClassificationEnum.DISASSEMBLY.value()).append("-").append(date.getYear()).append("-").append(date.getMonthValue());

        String searchReportNumber = reportNumber.toString().concat("%");
        List<String> reportNoList = workReportEquipmentDisassemblyRepository.selectEquipmentDisassemblyReportCount(searchReportNumber);

        int reportCount = 0;
        if (!reportNoList.isEmpty()) {
            String reportNo = reportNoList.get(0);
            reportCount = Integer.parseInt(reportNo.substring(reportNo.length() - 4), 10);
        }

        return reportNumber.append("-").append(String.format("%04d", reportCount + 1)).toString();
    }
}

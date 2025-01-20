package com.airpremia.eosh.report.workreport.facility.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.WorkReportCommon;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityPageResponse;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityRequest;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityResponse;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilitySearchRequest;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityUpdateQuantityRequest;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityUpdateRequest;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityPageDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilitySearchDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityUpdateDto;
import com.airpremia.eosh.report.workreport.facility.repository.WorkReportFacilityRepository;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkReportClassificationEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkReportFacilityService {

    private final WorkReportFacilityRepository workReportFacilityRepository;
    private final WorkReportCommon workReportCommon;
    private static final int INSPECTION_YEAR = 1;
    private static final int INSPECTION_MONTH = 9;

    public Page<WorkReportFacilityPageResponse> selectWorkReportFacilityPage(
        WorkReportFacilitySearchRequest workReportFacilitySearchRequest, Pageable pageable) {

        WorkReportFacilitySearchDto dto = new WorkReportFacilitySearchDto(workReportFacilitySearchRequest);

        Page<WorkReportFacilityPageDto> pageDto =
            workReportFacilityRepository.selectWorkReportFacilityPage(dto, pageable);

        return pageDto.map(WorkReportFacilityPageResponse::new);
    }

    public WorkReportFacilityResponse selectWorkReportFacility(Long workReportConstructionSeq) {
        WorkReportFacilityDto dto =
            workReportFacilityRepository.selectWorkReportFacility(workReportConstructionSeq);
        if (dto == null) {
            dto = new WorkReportFacilityDto();
        }
        return dto.convertWorkReportFacilityResponse();
    }

    public int updateWorkReportFacility(WorkReportFacilityUpdateRequest req, Long facilitySeq) {
        WorkReportFacilityUpdateDto dto = new WorkReportFacilityUpdateDto(req);
        return workReportFacilityRepository.updateWorkReportFacility(dto, facilitySeq);
    }

    public int insertWorkReportFacility(WorkReportFacilityRequest req) {
        WorkReportFacilityDto dto = new WorkReportFacilityDto(req);

        dto = workReportCommon.getStorageDepartmentCode(dto, WorkReportFacilityDto::setStorageDepartmentCode);

        dto.setReportNo(makeWorkReportNo());

        return workReportFacilityRepository.insertWorkReportFacility(dto);
    }

    public int deleteWorkReportFacility(Long workReportConstructionSeq) {
        return workReportFacilityRepository.deleteWorkReportFacility(workReportConstructionSeq);
    }

    public int updateWorkReportFacilityStatus(WorkReportFacilityRequest req, Long facilitySeq) {
        WorkReportFacilityDto dto = new WorkReportFacilityDto(req);

        if (dto.getApprovalWorkReportStatusEnum() == ApprovalWorkReportStatusEnum.APPROVAL) {
            LocalDate now = LocalDate.now();
            LocalDate firstTimeInspectionDt = now.plusYears(INSPECTION_YEAR).plusMonths(INSPECTION_MONTH);     // 승인날짜 기준 최초검사일 생성(+1년9개월)
            dto.setFirstTimeInspectionDt(firstTimeInspectionDt);
            dto.setRegistrationDt(now);
        }

        return workReportFacilityRepository.updateWorkReportFacilityStatus(dto, facilitySeq);
    }

    public int updateQuantity(WorkReportFacilityUpdateQuantityRequest req) {
        WorkReportFacilityDto dto = new WorkReportFacilityDto(req);
        return workReportFacilityRepository.updateQuantity(dto);
    }

    public String makeWorkReportNo() {
        LocalDate date = LocalDate.now();
        StringBuilder reportNumber = new StringBuilder();

        reportNumber.append(WorkReportClassificationEnum.FACILITY.value()).append("-").append(date.getYear()).append("-").append(date.getMonthValue());

        String searchReportNumber = reportNumber.toString().concat("%");
        List<String> reportNoList = workReportFacilityRepository.selectFacilityReportCount(searchReportNumber);

        int reportCount = 0;
        if (!reportNoList.isEmpty()) {
            String reportNo = reportNoList.get(0);
            reportCount = Integer.parseInt(reportNo.substring(reportNo.length() - 4), 10);
        }

        return reportNumber.append("-").append(String.format("%04d", reportCount + 1)).toString();
    }
}

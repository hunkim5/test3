package com.airpremia.eosh.report.workreport.safeguarding.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.WorkReportCommon;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectGearRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectGearResponse;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectGearSearchRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectiondeviceRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectiondeviceResponse;
import com.airpremia.eosh.report.workreport.safeguarding.controller.UserProtectiondeviceSearchRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingResponse;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingSearchRequest;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectGearDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectiondeviceDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.WorkReportSafeguardingDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.WorkReportSafeguardingSearchDto;
import com.airpremia.eosh.report.workreport.safeguarding.repository.WorkReportSafeguardingRepository;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkReportClassificationEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkReportSafeguardingService {

    private final WorkReportSafeguardingRepository workReportSafeguardingRepository;
    private final CommonFunction commonFunction;
    private final WorkReportCommon workReportCommon;

    public Page<WorkReportSafeguardingResponse> selectWorkReportSafeguardingPage(
        WorkReportSafeguardingSearchRequest workReportSafeguardingSearchRequest, Pageable pageable) {

        WorkReportSafeguardingSearchDto dto = new WorkReportSafeguardingSearchDto(workReportSafeguardingSearchRequest);
        Page<WorkReportSafeguardingDto> pageDto =
            workReportSafeguardingRepository.selectWorkReportSafeguardingPage(dto, pageable);

        return pageDto.map(WorkReportSafeguardingResponse::new);
    }

    public WorkReportSafeguardingResponse selectWorkReportSafeguarding(Long workReportSafeguardingSeq) {
        WorkReportSafeguardingDto dto =
            workReportSafeguardingRepository.selectWorkReportSafeguarding(workReportSafeguardingSeq);
        if (dto == null) {
            dto = new WorkReportSafeguardingDto();
        }
        return dto.convertWorkReportSafeguardingResponse();
    }

    public int updateWorkReportSafeguarding(WorkReportSafeguardingRequest req) {
        WorkReportSafeguardingDto dto = new WorkReportSafeguardingDto(req);
        return workReportSafeguardingRepository.updateWorkReportSafeguarding(dto);
    }

    public int insertWorkReportSafeguarding(WorkReportSafeguardingRequest req) {
        WorkReportSafeguardingDto dto = new WorkReportSafeguardingDto(req);

        dto = workReportCommon.getStorageDepartmentCode(dto, WorkReportSafeguardingDto::setStorageDepartmentCode);

        dto.setReportNo(makeWorkReportNo());

        return workReportSafeguardingRepository.insertWorkReportSafeguarding(dto);
    }

    public int deleteWorkReportSafeguarding(Long workReportSafeguardingSeq) {
        return workReportSafeguardingRepository.deleteWorkReportSafeguarding(workReportSafeguardingSeq);
    }

    @Transactional
    public int updateWorkReportSafeguardingStatus(WorkReportSafeguardingRequest req) {
        WorkReportSafeguardingDto dto = new WorkReportSafeguardingDto(req);
        int result = 0;
        if (dto.getApprovalWorkReportStatusEnum() == ApprovalWorkReportStatusEnum.APPROVAL) {
            if (dto.getSafeguardingCode() == null && dto.getProtectGearCode() == null) {
                throw new ExpectedException(ExceptionCode.WRONG_DATA);
            }
            if (dto.getProtectGearCode() != null) {
                result += handleProtectGearApproval(dto);
            }
            LocalDate now = LocalDate.now();
            dto.setRegistrationDt(now);
        }
        result += workReportSafeguardingRepository.updateWorkReportSafeguardingStatus(dto);
        return result;
    }

    private int handleProtectGearApproval(WorkReportSafeguardingDto dto) {
        int deptProtectGearCount = workReportSafeguardingRepository.selectDeptProtectGearCount(dto);
        if (deptProtectGearCount > 0) {
            return workReportSafeguardingRepository.updateDeptProtectGearQuantity(dto);
        }
        return workReportSafeguardingRepository.insertDeptProtectGearQuantity(dto);
    }

    public Page<UserProtectiondeviceResponse> selectUserProtectiondevicePage(
        UserProtectiondeviceSearchRequest request, Pageable pageable) {

        UserProtectiondeviceDto dto = new UserProtectiondeviceDto(request);
        Page<UserProtectiondeviceDto> pageDto =
            workReportSafeguardingRepository.selectUserProtectiondevicePage(dto, pageable);

        return pageDto.map(UserProtectiondeviceResponse::new);
    }

    public Page<UserProtectGearResponse> selectUserProtectGearPage(
        UserProtectGearSearchRequest request, Pageable pageable) {

        UserProtectGearDto dto = new UserProtectGearDto(request);
        Page<UserProtectGearDto> pageDto =
            workReportSafeguardingRepository.selectUserProtectGearPage(dto, pageable);

        return pageDto.map(UserProtectGearResponse::new);
    }

    public Integer updateUserProtectionDeviceQuantity(UserProtectiondeviceRequest req) {
        UserProtectiondeviceDto dto = new UserProtectiondeviceDto(req);
        int result = 0;
        result += workReportSafeguardingRepository.updateUserProtectiondeviceQuantity(dto);
        if (String.valueOf(req.getQuantity()).equals("")) {
            dto.setQuantity(req.getQuantity() - req.getOriginalQuantity());
            result += workReportSafeguardingRepository.updateWorkReportSafeguardingSafeguardingQuantity(dto);
        }
        return result;
    }

    public Integer updateWorkReportSafeguardingProtectGearQuantity(UserProtectGearRequest req) {
        UserProtectGearDto dto = new UserProtectGearDto(req);
        int result = 0;
        result += workReportSafeguardingRepository.updateUserProtectGearQuantity(dto);
        if (!String.valueOf(req.getQuantity()).equals("")) {
            dto.setQuantity(req.getQuantity() - req.getOriginalQuantity());
            result += workReportSafeguardingRepository.updateWorkReportSafeguardingProtectGearQuantity(dto);
        }
        return result;
    }

    public String makeWorkReportNo() {
        LocalDate date = LocalDate.now();
        StringBuilder reportNumber = new StringBuilder();

        reportNumber.append(WorkReportClassificationEnum.SAFEGUARD.value()).append("-").append(date.getYear()).append("-").append(date.getMonthValue());

        String searchReportNumber = reportNumber.toString().concat("%");
        List<String> reportNoList = workReportSafeguardingRepository.selectSafeguardingReportCount(searchReportNumber);

        int reportCount = 0;
        if (!reportNoList.isEmpty()) {
            String reportNo = reportNoList.get(0);
            reportCount = Integer.parseInt(reportNo.substring(reportNo.length() - 4), 10);
        }

        return reportNumber.append("-").append(String.format("%04d", reportCount + 1)).toString();
    }
}

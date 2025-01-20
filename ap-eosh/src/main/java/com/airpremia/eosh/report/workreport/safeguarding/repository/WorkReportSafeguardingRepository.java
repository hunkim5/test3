package com.airpremia.eosh.report.workreport.safeguarding.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectGearDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectiondeviceDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.WorkReportSafeguardingDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.WorkReportSafeguardingSearchDto;


@Repository
public interface WorkReportSafeguardingRepository {

    int insertWorkReportSafeguarding(WorkReportSafeguardingDto insertDto);

    int updateWorkReportSafeguarding(WorkReportSafeguardingDto updateDto);

    int selectDeptProtectGearCount(WorkReportSafeguardingDto dto);

    int updateDeptProtectGearQuantity(WorkReportSafeguardingDto dto);

    int insertDeptProtectGearQuantity(WorkReportSafeguardingDto insertDto);

    int insertDeptSafeguardingQuantity(WorkReportSafeguardingDto insertDto);

    int updateWorkReportSafeguardingStatus(WorkReportSafeguardingDto updateDto);

    int deleteWorkReportSafeguarding(Long workReportConstructionSeq);

    Page<WorkReportSafeguardingDto> selectWorkReportSafeguardingPage(
        @Param(value = "searchDto") WorkReportSafeguardingSearchDto dto, Pageable pageable);

    WorkReportSafeguardingDto selectWorkReportSafeguarding(Long safeguardingSeq);

    Page<UserProtectiondeviceDto> selectUserProtectiondevicePage(
        @Param(value = "searchDto") UserProtectiondeviceDto dto, Pageable pageable);

    Page<UserProtectGearDto> selectUserProtectGearPage(
        @Param(value = "searchDto") UserProtectGearDto dto, Pageable pageable);

    int updateUserProtectiondeviceQuantity(UserProtectiondeviceDto dto);

    int updateUserProtectGearQuantity(UserProtectGearDto dto);

    int updateWorkReportSafeguardingSafeguardingQuantity(UserProtectiondeviceDto dto);

    int updateWorkReportSafeguardingProtectGearQuantity(UserProtectGearDto dto);

    List<String> selectSafeguardingReportCount(String searchReportNumber);
}

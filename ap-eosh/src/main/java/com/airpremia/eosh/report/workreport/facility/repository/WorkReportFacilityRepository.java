package com.airpremia.eosh.report.workreport.facility.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityPageDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilitySearchDto;
import com.airpremia.eosh.report.workreport.facility.dto.WorkReportFacilityUpdateDto;

@Repository
public interface WorkReportFacilityRepository {

    int insertWorkReportFacility(WorkReportFacilityDto insertDto);

    List<String> selectFacilityReportCount(String searchReportNumber);

    int updateWorkReportFacility(WorkReportFacilityUpdateDto updateDto, Long facilitySeq);

    int updateWorkReportFacilityStatus(WorkReportFacilityDto updateDto, Long facilitySeq);

    int deleteWorkReportFacility(Long workReportConstructionSeq);

    int updateQuantity(WorkReportFacilityDto updateDto);

    Page<WorkReportFacilityPageDto> selectWorkReportFacilityPage(
        @Param(value = "searchDto") WorkReportFacilitySearchDto dto, Pageable pageable);

    WorkReportFacilityDto selectWorkReportFacility(Long workReportConstructionSeq);
}

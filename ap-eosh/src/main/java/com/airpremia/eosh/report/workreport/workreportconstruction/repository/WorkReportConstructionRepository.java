package com.airpremia.eosh.report.workreport.workreportconstruction.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.report.workreport.workreportconstruction.dto.WorkReportConstructionDto;
import com.airpremia.eosh.report.workreport.workreportconstruction.dto.WorkReportConstructionPageDto;

@Repository
public interface WorkReportConstructionRepository {


    List<String> selectConstructionReportCount(String searchReportNumber);

    int insertWorkReportConstruction(WorkReportConstructionDto insertDto);

    int updateWorkReportConstruction(WorkReportConstructionDto updateDto);

    int updateWorkReportConstructionStatus(WorkReportConstructionDto updateDto);

    int deleteWorkReportConstruction(Long workReportConstructionSeq);

    Page<WorkReportConstructionPageDto> selectWorkReportConstructionPage(
        @Param(value = "searchDto") WorkReportConstructionPageDto dto, Pageable pageable);

    WorkReportConstructionDto selectWorkReportConstruction(Long workReportConstructionSeq);
}

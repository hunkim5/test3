package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblyDto;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblyPageDto;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto.WorkReportEquipmentDisassemblySearchDto;


@Repository
public interface WorkReportEquipmentDisassemblyRepository {


    int insertWorkReportEquipmentDisassembly(WorkReportEquipmentDisassemblyDto insertDto);

    int updateWorkReportEquipmentDisassembly(WorkReportEquipmentDisassemblyDto updateDto);

    int updateWorkReportEquipmentDisassemblyStatus(WorkReportEquipmentDisassemblyDto updateDto);

    int deleteWorkReportEquipmentDisassembly(Long workReportConstructionSeq);

    Page<WorkReportEquipmentDisassemblyPageDto> selectWorkReportEquipmentDisassemblyPage(
        @Param(value = "searchDto") WorkReportEquipmentDisassemblySearchDto dto, Pageable pageable);

    WorkReportEquipmentDisassemblyDto selectWorkReportEquipmentDisassembly(Long workReportEquipmentDisassemblySeq);

    List<String> selectEquipmentDisassemblyReportCount(String searchReportNumber);

}

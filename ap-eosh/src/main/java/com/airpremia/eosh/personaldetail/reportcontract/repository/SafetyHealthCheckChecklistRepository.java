package com.airpremia.eosh.personaldetail.reportcontract.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.reportcontract.dto.SafetyHealthCheckChecklistDto;

@Repository
public interface SafetyHealthCheckChecklistRepository {

    int insertSafetyHealthCheckChecklist(SafetyHealthCheckChecklistDto insertDto);

    int updateSafetyHealthCheckChecklist(SafetyHealthCheckChecklistDto updateDto);

    int deleteSafetyHealthCheckChecklist(Long contractSeq);

    List<SafetyHealthCheckChecklistDto> selectSafetyHealthCheckChecklist(Long contractSeq);

}

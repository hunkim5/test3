package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.SafetyHealthMeasuresRequirementsDto;

@Repository
public interface SafetyHealthMeasuresRequirementsRepository {
    List<SafetyHealthMeasuresRequirementsDto> selectSafetyHealthMeasuresRequirements(
        Long safetyHealthMeasuresRequirementsSeq);

    int insertSafetyHealthMeasuresRequirementsList(List<SafetyHealthMeasuresRequirementsDto> safetyRequirementList);

    int updateSafetyHealthMeasuresRequirements(SafetyHealthMeasuresRequirementsDto updateDto);

    int deleteSafetyHealthMeasuresRequirementsList(List<Long> safetyRequirementList);
}

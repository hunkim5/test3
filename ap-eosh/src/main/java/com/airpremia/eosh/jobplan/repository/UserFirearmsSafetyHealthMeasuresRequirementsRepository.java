package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.UserFirearmsSafetyHealthMeasuresRequirementsDto;


@Repository
public interface UserFirearmsSafetyHealthMeasuresRequirementsRepository {

    List<UserFirearmsSafetyHealthMeasuresRequirementsDto> selectUserFirearmsSafetyHealthMeasuresRequirements(
        Long userFirearmsSafetyHealthMeasuresRequirementsSeq);

    int insertUserFirearmsSafetyHealthMeasuresRequirements(
        List<UserFirearmsSafetyHealthMeasuresRequirementsDto> firearmsSafetyRequirementList);

    int updateUserFirearmsSafetyHealthMeasuresRequirements(UserFirearmsSafetyHealthMeasuresRequirementsDto updateDto);

    int deleteUserFirearmsSafetyHealthMeasuresRequirements(List<Long> firearmsSafetyRequirementList);
}

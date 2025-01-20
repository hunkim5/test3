package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.ConfinedPlaceJobPlanPermissionDto;


@Repository
public interface ConfinedPlaceJobPlanPermissionRepository {
    ConfinedPlaceJobPlanPermissionDto selectConfinedPlaceJobPlanPermission(Long jobSeq);

    int insertConfinedPlaceJobPlanPermission(ConfinedPlaceJobPlanPermissionDto updateDto);

    int updateConfinedPlaceJobPlanPermissionHarmful(ConfinedPlaceJobPlanPermissionDto updateDto);

    int deleteConfinedPlaceJobPlanPermission(List<Long> deleteSeqList);

}

package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.FirearmsJobPlanPermissionDto;


@Repository
public interface FirearmsJobPlanPermissionRepository {

    int insertFirearmsJobPlanPermission(FirearmsJobPlanPermissionDto updateDto);

    int updateFirearmsJobPlanPermission(FirearmsJobPlanPermissionDto updateDto);

    int deleteFirearmsJobPlanPermission(List<Long> deleteSeqList);

    FirearmsJobPlanPermissionDto selectFirearmsJobPlanPermission(Long jobSeq);
}

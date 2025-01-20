package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;


@Repository
public interface JobEmployeeProtectGearCheckRepository {

    List<JobEmployeeProtectGearCheckDto> selectJobEmployeeProtectGearCheckList(Long jobSeq);

    int insertJobEmployeeProtectGearCheckList(List<JobEmployeeProtectGearCheckDto> employeeProtectGearList);

    int updateJobEmployeeProtectGearCheck(JobEmployeeProtectGearCheckDto updateDto);

    int deleteJobEmployeeProtectGearCheckList(List<Long> registeredEmployeeProtectGearSeqList);
}

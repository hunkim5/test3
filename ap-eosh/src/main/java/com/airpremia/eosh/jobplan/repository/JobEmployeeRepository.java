package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.JobEmployeeDto;
import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;


@Repository
public interface JobEmployeeRepository {

    List<JobEmployeeDto> selectJobEmployeeList(Long toolBoxMeetingSeq);

    List<JobEmployeeDto> selectJobEmployeeJobList(Long jobSeq);

    List<JobEmployeeProtectGearCheckDto> jobEmployeeProtectGearList(Long jobSeq);

    Long getJobEmployeeSeq(String userSeq, Long jobSeq);

    int insertJobEmployee(JobEmployeeDto insertDto);

    int insertJobEmployeeList(List<JobEmployeeDto> employeeList);

    int updateJobEmployee(JobEmployeeDto updateDto);

    int updateJobEmployeeSignature(JobEmployeeDto updateDto);

    int updateJobEmployeeSignatureTbm(JobEmployeeDto updateDto);

    int deleteJobEmployeeList(List<Long> employeeSeqList);

    int deleteJobEmployee(Long jobEmployee);

    List<JobEmployeeDto> selectJobEmployeeListByUser(Long toolBoxMeetingSeq, String jobEmployeeNumber);

}

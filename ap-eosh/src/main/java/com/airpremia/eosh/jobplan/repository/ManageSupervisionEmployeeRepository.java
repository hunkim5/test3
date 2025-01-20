package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;


@Repository
public interface ManageSupervisionEmployeeRepository {

    int insertManageSupervisionEmployee(ManageSupervisionEmployeeDto insertDto);

    int insertManageSupervisionEmployeeList(List<ManageSupervisionEmployeeDto> managerList);

    int updateManageSupervisionEmployee(ManageSupervisionEmployeeDto updateDto);

    int deleteManageSupervisionEmployee(Long manageSupervisionEmployeeSeq);

    int deleteManageSupervisionEmployeeList(List<Long> managerSeqList);

    List<ManageSupervisionEmployeeDto> selectManageSupervisionEmployeeList(Long toolBoxMeetingSeq);

    List<ManageSupervisionEmployeeDto> selectManageSupervisionEmployeeJobList(Long jobSeq);

}

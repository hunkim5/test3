package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.JobPlanDto;

@Repository
public interface JobPlanRepository {

    int insertJobPlan(JobPlanDto insertDto);

    int updateJobPlan(JobPlanDto updateDto);

    int deleteJobPlan(List<Long> deleteSeqList);

    Page<JobPlanDto> selectJobPlanPage(JobPlanDto searchDto, Pageable pageable);

    JobPlanDto selectJobPlan(Long workReportConstructionSeq);
}

package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.JobWalkieTalkieDto;


@Repository
public interface JobWalkieTalkieRepository {

    List<JobWalkieTalkieDto> selectJobWalkieTalkie(Long jobSeq);

    int insertJobWalkieTalkieList(List<JobWalkieTalkieDto> jobWalkieTalkieList);

    int updateJobWalkieTalkie(JobWalkieTalkieDto updateDto);

    int deleteJobWalkieTalkieList(List<Long> registeredJobWalkieTalkieSeqList);

    int deleteJobWalkieTalkieListByJobPlanSeq(List<Long> deleteSeqList);

}

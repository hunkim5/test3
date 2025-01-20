package com.airpremia.eosh.personaldetail.reportcontract.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.reportcontract.dto.EvaluationTargetChecklistDto;

@Repository
public interface EvaluationTargetChecklistRepository {

    int insertEvaluationTargetChecklist(EvaluationTargetChecklistDto insertDto);

    int updateEvaluationTargetChecklist(EvaluationTargetChecklistDto updateDto);

    int deleteEvaluationTargetChecklist(Long contractSeq);

    List<EvaluationTargetChecklistDto> selectEvaluationTargetChecklist(Long contractSeq);

}

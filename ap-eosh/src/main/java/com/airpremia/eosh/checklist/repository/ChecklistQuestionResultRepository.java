package com.airpremia.eosh.checklist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.checklist.dto.ChecklistQuestionResultDto;


@Repository
public interface ChecklistQuestionResultRepository {
    List<ChecklistQuestionResultDto> selectChecklistQuestionResultList(long checklistSeq);

    int insertChecklistQuestionResultList(List<ChecklistQuestionResultDto> checklistResultList);

    int updateChecklistQuestionResult(ChecklistQuestionResultDto updateDto);

    int deleteChecklistQuestionResultList(List<Long> deleteSeqList);

}

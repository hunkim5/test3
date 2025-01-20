package com.airpremia.eosh.checklist.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.checklist.dto.ChecklistDto;


@Repository
public interface ChecklistRepository {
    Page<ChecklistDto> selectChecklistPage(@Param(value = "searchDto") ChecklistDto data, Pageable pageable);

    ChecklistDto selectChecklist(Long meetingSeq);

    Long selectChecklistByJobPlanSeq(Long jobSeq);

    int insertChecklist(ChecklistDto insertDto);

    int updateChecklist(ChecklistDto updateDto);

    int deleteChecklist(List<Long> deleteSeqList);

}

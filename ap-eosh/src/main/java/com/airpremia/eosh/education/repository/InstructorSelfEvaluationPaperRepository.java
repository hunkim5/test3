package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.InstructorSelfEvaluationPaperDto;


@Repository
public interface InstructorSelfEvaluationPaperRepository {

    InstructorSelfEvaluationPaperDto selectInstructorSelfEvaluationPaper(
        InstructorSelfEvaluationPaperDto dto);

    List<InstructorSelfEvaluationPaperDto> selectInstructorSelfEvaluationPaperList(Long educationInstructorSeq);

    int insertInstructorSelfEvaluationPaper(List<InstructorSelfEvaluationPaperDto> insertDtoList);

    int updateInstructorSelfEvaluationPaper(InstructorSelfEvaluationPaperDto updateDto);

    int deleteInstructorSelfEvaluationPaper(List<Long> educationInstructorSeqs);

    int deleteAllInstructorSelfEvaluationPaper(Long educationSeq);
}

package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.CourseEvalCountDto;
import com.airpremia.eosh.education.dto.EducationAttendUserDto;
import com.airpremia.eosh.education.dto.InstructorEvaluationDto;


@Repository
public interface InstructorEvaluationRepository {

    List<InstructorEvaluationDto> selectInstructorEvaluation(Long educationSeq, Long educationAttendUserSeq);

    int insertInstructorEvaluation(List<InstructorEvaluationDto> insertDtoList);

    int updateInstructorEvaluation(InstructorEvaluationDto updateDto);

    int deleteInstructorEvaluation(EducationAttendUserDto deleteDto);

    List<CourseEvalCountDto> selectInstructorEvaluationCount(List<Long> educationSeqs);

    int deleteAllInstructorEvaluation(Long educationSeq);

}

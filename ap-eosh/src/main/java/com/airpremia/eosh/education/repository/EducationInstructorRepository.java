package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.EducationInstructorDto;
import com.airpremia.eosh.education.dto.EducationInstructorUserNamesDto;


@Repository
public interface EducationInstructorRepository {

    List<EducationInstructorDto> selectEducationInstructorList(
        long educationSeq);

    int insertEducationInstructor(EducationInstructorDto insertDto);

    int updateEducationInstructor(EducationInstructorDto updateDto);

    int deleteEducationInstructor(List<Long> educationInstructorSeqs);

    List<EducationInstructorUserNamesDto> selectEducationInstructorUserNames(List<Long> educationSeqs);

    int deleteAllEducationInstructor(Long educationSeq);

}

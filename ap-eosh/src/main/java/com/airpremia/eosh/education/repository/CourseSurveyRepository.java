package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.CourseEvalCountDto;
import com.airpremia.eosh.education.dto.CourseSurveyDto;
import com.airpremia.eosh.education.dto.EducationAttendUserDto;


@Repository
public interface CourseSurveyRepository {

    CourseSurveyDto selectCourseSurvey(
        CourseSurveyDto dto);

    List<CourseSurveyDto> selectCourseSurveyList(Long educationAttendUserSeq);

    int insertCourseSurvey(List<CourseSurveyDto> insertDtoList);

    int updateCourseSurvey(CourseSurveyDto updateDto);

    int deleteCourseSurvey(EducationAttendUserDto deleteDto);

    List<CourseEvalCountDto> selectCourseSurveyCount(List<Long> educationSeqs);

    int deleteAllCourseSurvey(Long educationSeq);
}

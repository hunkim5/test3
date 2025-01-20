package com.airpremia.eosh.education.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.EducationDto;
import com.airpremia.eosh.education.dto.EducationListDto;


@Repository
public interface EducationRepository {

    int insertEducation(EducationDto insertDto);

    int updateEducation(EducationDto updateDto);

    int deleteEducation(Long workReportConstructionSeq);

    Page<EducationListDto> selectEducationPage(
        @Param(value = "searchDto") EducationDto dto, Pageable pageable);

    EducationDto selectEducation(Long educationSeq);

}

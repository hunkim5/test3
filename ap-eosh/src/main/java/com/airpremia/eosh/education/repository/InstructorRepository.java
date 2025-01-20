package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.InstructorDto;

@Repository
public interface InstructorRepository {

    List<InstructorDto> selectEducationInstructorList();

    Page<InstructorDto> selectEducationInstructorPage(Pageable pageable);

    InstructorDto selectInstructorDetail(Long instructorSeq);

    List<InstructorDto> selectInstructorDetailList(List<Long> instructorSeqs);

    int duplicateCheck(String userId);

    int insertInstructor(InstructorDto dataDto);

    int deleteInstructor(Long instructorSeq);

    String selectExternalUserId();
}

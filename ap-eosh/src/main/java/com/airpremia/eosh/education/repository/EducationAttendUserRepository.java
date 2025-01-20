package com.airpremia.eosh.education.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.education.dto.EducationAttendUserDto;


@Repository
public interface EducationAttendUserRepository {

    List<EducationAttendUserDto> selectEducationAttendUserList(
        long educationSeq);

    int insertEducationAttendUser(EducationAttendUserDto insertDto);

    int updateEducationAttendUser(EducationAttendUserDto updateDto);

    int deleteEducationAttendUser(EducationAttendUserDto deleteDto);

    int deleteAllEducationAttendUser(EducationAttendUserDto deleteDto);

}

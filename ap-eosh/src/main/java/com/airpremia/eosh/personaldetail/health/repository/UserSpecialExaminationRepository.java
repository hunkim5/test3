package com.airpremia.eosh.personaldetail.health.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserSpecialExaminationDto;

@Repository
public interface UserSpecialExaminationRepository {

    int insertUserSpecialExamination(UserSpecialExaminationDto dto);

    int updateUserSpecialExamination(UserSpecialExaminationDto dto);

    int deleteUserSpecialExamination(Long userSeq, String standardYyyy);

    UserSpecialExaminationDto selectUserSpecialExamination(
        Long userSeq, String standardYyyy);

    List<UserSpecialExaminationDto> selectUserSpecialExaminationPage(
        @Param(value = "searchDto") UserSpecialExaminationDto dto);

    UserSpecialExaminationDto selectUserSpecialExaminationInfo(HealthPageDto dto);

}

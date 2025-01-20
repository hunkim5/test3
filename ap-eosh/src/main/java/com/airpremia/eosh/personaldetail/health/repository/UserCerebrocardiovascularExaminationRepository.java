package com.airpremia.eosh.personaldetail.health.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationSearchDto;

@Repository
public interface UserCerebrocardiovascularExaminationRepository {

    int insertUserCerebrocardiovascularExamination(UserCerebrocardiovascularExaminationDto dto);

    int updateUserCerebrocardiovascularExamination(UserCerebrocardiovascularExaminationDto dto);

    int deleteUserCerebrocardiovascularExamination(Long userSeq, String standardYyyy);

    UserCerebrocardiovascularExaminationDto selectUserCerebrocardiovascularExamination(
        Long userSeq, String standardYyyy);

    List<UserCerebrocardiovascularExaminationPageDto> selectUserCerebrocardiovascularExaminationPage(
        @Param(value = "searchDto") UserCerebrocardiovascularExaminationSearchDto dto);

    UserCerebrocardiovascularExaminationDto selectCerebrocardiovascularExaminationInfo(HealthPageDto dto);

}

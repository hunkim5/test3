package com.airpremia.eosh.personaldetail.health.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationSearchDto;

@Repository
public interface UserCosmicRadiationExaminationRepository {

    int insertUserCosmicRadiationExamination(UserCosmicRadiationExaminationDto dto);

    int updateUserCosmicRadiationExamination(UserCosmicRadiationExaminationDto dto);

    int deleteUserCosmicRadiationExamination(Long userSeq, String standardYyyy);

    UserCosmicRadiationExaminationDto selectUserCosmicRadiationExamination(
        Long userSeq, String standardYyyy);

    List<UserCosmicRadiationExaminationPageDto> selectUserCosmicRadiationExaminationPage(
        @Param(value = "searchDto") UserCosmicRadiationExaminationSearchDto dto);

    UserCosmicRadiationExaminationDto selectCosmicRadiationExaminationInfo(HealthPageDto dto);
}

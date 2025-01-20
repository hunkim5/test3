package com.airpremia.eosh.personaldetail.health.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailFirstDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailSecondDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.RealTimePublicNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UpdateUserSexDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationSearchDto;

@Repository
public interface HealthRepository {

    int updateUserSex(UpdateUserSexDto dto);

    List<HealthPageDto> selectHealthPage(HealthSearchDto searchDto);

    UserNormalExaminationDto selectUserNormalExamination(
        Long userSeq, String standardYyyy);

    List<UserNormalExaminationPageDto> selectUserNormalExaminationPage(
        @Param(value = "searchDto") UserNormalExaminationSearchDto dto);

    List<UserCerebrocardiovascularExaminationPageDto> selectUserNormalExaminationPage(
        @Param(value = "searchDto") UserCerebrocardiovascularExaminationSearchDto dto);


    int insertRealTimeUserNormalExamination(RealTimePublicNormalExaminationDto dto);

    int insertUserNormalExamination(UserNormalExaminationDto dto);

    int updateRealTimeUserNormalExamination(RealTimePublicNormalExaminationDto dto);

    int updateUserNormalExamination(UserNormalExaminationDto dto);

    int deleteUserNormalExamination(Long userSeq, String standardYyyy);

    List<String> selectUserNormalExaminationCheck(UserNormalExaminationDto dto);

    Long selectUserSeq(String empId);

    HealthCheckDetailFirstDto selectHealthCheckFirstDetailPage(
        @Param("userId") String userId,
        @Param("standardYyyy") String standardYyyy);

    HealthCheckDetailSecondDto selectHealthCheckSecondDetailPage(
        @Param("userId") String userId,
        @Param("standardYyyy") String standardYyyy);
}

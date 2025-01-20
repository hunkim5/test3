package com.airpremia.eosh.personaldetail.health.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyPageResponse;
import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyAnswerDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyInsertUpdateDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveySearchDto;
import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveyReportDto;
import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveySubmittedUsersDto;
import com.airpremia.eosh.personaldetail.health.enums.SurveyStatusEnum;

@Repository
public interface WorkStressSurveyRepository {

    List<UserWorkStressSurveyPageResponse> selectUserWorkStressSurveyPage(
        @Param(value = "searchDto") UserWorkStressSurveySearchDto searchDto, Pageable pageable);

    List<UserWorkStressSurveyDto> selectUserWorkStressSurvey(Long userSeq, String standardYyyy);

    List<WorkStressSurveyReportDto> selectUserStressSurveyResult(WorkStressSurveyReportDto dto);

    int insertUserWorkStressSurvey(UserWorkStressSurveyInsertUpdateDto dto);

    int updateUserWorkStressSurvey(UserWorkStressSurveyInsertUpdateDto dto);

    int checkUserWorkStressSurveyAnswerSave(
        UserWorkStressSurveyAnswerDto dto);

    int insertUserWorkStressSurveyAnswer(UserWorkStressSurveyAnswerDto dto);

    int updateUserWorkStressSurveyAnswer(UserWorkStressSurveyAnswerDto dto);

    long selectWorkStressSurveyUserSeq(String userId);

    int updateUserSex(UserWorkStressSurveyInsertUpdateDto reqDto);

    WorkStressSurveyReportDto selectWorkStressSurveyScore(HealthPageDto dto);

    List<WorkStressSurveySubmittedUsersDto> selectSurveySubmittedUsers(String standardYyyy);

    List<WorkStressSurveySubmittedUsersDto> selectSurveySubmittedDeptUsers(String standardYyyy, String deptCd);

    SurveyStatusEnum checkSurveyStatus(UserWorkStressSurveyDto dto);
}

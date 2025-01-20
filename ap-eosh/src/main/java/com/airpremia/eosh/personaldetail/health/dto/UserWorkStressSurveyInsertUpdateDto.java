package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyInsertUpdateRequest;
import com.airpremia.eosh.personaldetail.health.enums.SurveyStatusEnum;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserWorkStressSurveyInsertUpdateDto {
    private Long userSeq;

    private String userId;

    private String standardYyyy;

    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;

    private double averageScore;

    private SurveyStatusEnum surveyStatus;

    private List<UserWorkStressSurveyAnswerDto> userWorkStressSurveyAnswerDtoList;

    private UserSexEnum sex;

    private String insertUserId;

    private String insertIp;

    private LocalDateTime insertDtm;

    private String updateUserId;

    private String updateIp;

    private LocalDateTime updateDtm;

    public UserWorkStressSurveyInsertUpdateDto(UserWorkStressSurveyInsertUpdateRequest req) {
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.surveyStatus = req.getSurveyStatus();
        this.userWorkStressSurveyAnswerDtoList =
            req.getUserWorkStressSurveyAnswerRequestList().stream().map(UserWorkStressSurveyAnswerDto::new).toList();
        this.sex = req.getSex();
    }


}


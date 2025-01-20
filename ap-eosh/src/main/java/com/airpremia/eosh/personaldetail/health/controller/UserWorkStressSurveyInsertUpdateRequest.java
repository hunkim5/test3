package com.airpremia.eosh.personaldetail.health.controller;

import java.util.List;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.SurveyStatusEnum;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveyInsertUpdateRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "직군 분류")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "질문 상태")
    private SurveyStatusEnum surveyStatus;
    @Schema(description = "설문지 답변")
    private List<UserWorkStressSurveyAnswerRequest> userWorkStressSurveyAnswerRequestList;
    @Schema(description = "사용자 성별")
    private UserSexEnum sex;
}


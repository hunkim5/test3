package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveySearchDto;
import com.airpremia.eosh.personaldetail.health.enums.UserSexEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWorkStressSurveySearchRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "직군 분류")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "설문 상태")
    private String surveyStatus;
    @Schema(description = "부서 코드")
    private String deptCd;
    @Schema(description = "성별")
    private UserSexEnum sex;

    public UserWorkStressSurveySearchDto convertUserWorkStressSurveySearchDto() {
        UserWorkStressSurveySearchDto data = new UserWorkStressSurveySearchDto();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setSurveyStatus(this.surveyStatus);
        data.setDeptCd(this.deptCd);
        data.setSex(this.sex);
        return data;
    }
}


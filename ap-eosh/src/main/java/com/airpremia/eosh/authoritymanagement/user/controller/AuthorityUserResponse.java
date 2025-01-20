package com.airpremia.eosh.authoritymanagement.user.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.user.entities.UserEntity;
import com.airpremia.eosh.authoritymanagement.user.enums.Sex;
import com.airpremia.eosh.authoritymanagement.user.enums.UserGradeEnum;
import com.airpremia.eosh.authoritymanagement.user.enums.UserStatusEnum;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityUserResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 '직군' 분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "안전 직책 코드")
    private String safetyOfficeCode;
    @Schema(description = "사용자 상태 ENUM")
    private UserStatusEnum userStatusEnum;
    @Schema(description = "사용자 등급 ENUM")
    private UserGradeEnum userGradeEnum;
    @Schema(description = "요청 권한 여부")
    private boolean requestAuthorityBool;
    @Schema(description = "요청 기간 시작")
    private LocalDate requestPeriodStart;
    @Schema(description = "요청 기간 종료")
    private LocalDate requestPeriodEnd;
    @Schema(description = "성별")
    private Sex sex;
    @Schema(description = "부서 코드")
    private String deptCd;

    public AuthorityUserResponse(UserEntity entity) {
        this.userSeq = entity.getUserSeq();
        this.userId = entity.getUserId();
        this.userJobClassificationClassificationEnum = entity.getUserJobClassificationClassificationEnum();
        this.safetyOfficeCode = entity.getSafetyOfficeCode();
        this.userStatusEnum = entity.getUserStatusEnum();
        this.userGradeEnum = entity.getUserGradeEnum();
        this.requestAuthorityBool = entity.isRequestAuthorityBool();
        this.requestPeriodStart = entity.getRequestPeriodStart();
        this.requestPeriodEnd = entity.getRequestPeriodEnd();
        this.sex = entity.getSex();
        this.deptCd = entity.getDeptCd();
    }
}

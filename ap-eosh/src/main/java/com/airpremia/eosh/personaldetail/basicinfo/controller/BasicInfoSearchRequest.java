package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasicInfoSearchRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 ID")
    private String userId;
    @Schema(description = "사용자 권한")
    private AuthorityManagementUserGradeEnum userGradeEnum;
    @Schema(description = "사용자 '직군' 분류 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "사용자 이름")
    private String empNm;
    @Schema(description = "사용자 직책")
    private String postNm;
    @Schema(description = "사용자 부서명")
    private String deptNm;
    @Schema(description = "사용자 입사일 시작일")
    private LocalDate hireYmdFrom;
    @Schema(description = "사용자 입사일 종료일")
    private LocalDate hireYmdTo;

    @Schema(description = "사용자 입사일")
    private LocalDate hireYmd;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사용자 이메일")
    private String email;
    @Schema(description = "사용자 핸드폰번호")
    private String handphone;
}


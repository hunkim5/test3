package com.airpremia.eosh.authoritymanagement.authorityrequest.controller;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityRequestSearchRequest {
    @Schema(description = "요청 등급 ENUM")
    private AuthorityManagementUserGradeEnum requestLevel;
    @Schema(description = "요청 기간 시작")
    private LocalDate requestPeriodStart;
    @Schema(description = "요청 기간 종료")
    private LocalDate requestPeriodEnd;
    @Schema(description = "요청 사유")
    private String requestReason;
    @Schema(description = "요청 상태")
    private RequestStatusEnum requestStatus;
    @Schema(description = "삽입 사용자 아이디")
    private String updateUserId;
    @Schema(description = "삽입 IP")
    private String updateIp;
    @Schema(description = "화면 구분")
    private String gubun;
    @Schema(description = "사번")
    private List<String> empNoList;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "이름")
    private String empNm;
}


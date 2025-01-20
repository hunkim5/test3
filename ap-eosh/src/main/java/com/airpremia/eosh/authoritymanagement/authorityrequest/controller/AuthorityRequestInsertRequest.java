package com.airpremia.eosh.authoritymanagement.authorityrequest.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityRequestInsertRequest {
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
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
}


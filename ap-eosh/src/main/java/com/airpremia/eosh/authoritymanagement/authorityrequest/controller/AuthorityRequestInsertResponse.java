package com.airpremia.eosh.authoritymanagement.authorityrequest.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestInsertDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestInsertResponse {
    @Schema(description = "요청 일련번호")
    private Long userAuthorityRequestSeq;
    @Schema(description = "사용자 시퀀스")
    private long userSeq;
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

    public AuthorityRequestInsertResponse(AuthorityRequestInsertDto dto) {
        this.userSeq = dto.getUserSeq();
        this.requestLevel = dto.getRequestLevel();
        this.requestPeriodStart = dto.getRequestPeriodStart();
        this.requestPeriodEnd = dto.getRequestPeriodEnd();
        this.requestReason = dto.getRequestReason();
        this.requestStatus = dto.getRequestStatus();
        this.insertUserId = dto.getInsertUserId();
        this.insertIp = dto.getInsertIp();
    }
}


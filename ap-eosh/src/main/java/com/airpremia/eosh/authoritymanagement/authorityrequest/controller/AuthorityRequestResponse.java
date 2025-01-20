package com.airpremia.eosh.authoritymanagement.authorityrequest.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestDto;
import com.airpremia.eosh.authoritymanagement.authorityrequest.dto.AuthorityRequestPageDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestResponse {
    @Schema(description = "요청 일련번호")
    private Long userAuthorityRequestSeq;
    @Schema(description = "요청 등급 ENUM")
    private AuthorityManagementUserGradeEnum requestLevel;
    @Schema(description = "요청 기간 시작")
    private LocalDate requestPeriodStart;
    @Schema(description = "요청 기간 종료")
    private LocalDate requestPeriodEnd;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "요청 사유")
    private String requestReason;
    @Schema(description = "요청 상태")
    private RequestStatusEnum requestStatus;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "Emp Number")
    private String empNo;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "부서 code")
    private String deptCd;
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "핸드폰번호")
    private String handphone;
    @Schema(description = "생년월일")
    private LocalDate birthYmd;
    @Schema(description = "직위")
    private String postNm;
    @Schema(description = "입사일")
    private LocalDate hireYmd;

    public AuthorityRequestResponse(AuthorityRequestDto data) {
        this.userAuthorityRequestSeq = data.getUserAuthorityRequestSeq();
        this.requestLevel = data.getRequestLevel();
        this.requestPeriodStart = data.getRequestPeriodStart();
        this.requestPeriodEnd = data.getRequestPeriodEnd();
        this.requestStatus = data.getRequestStatus();
        this.requestReason = data.getRequestReason();
        this.empNm = data.getEmpNm();
        this.empNo = data.getEmpNo();
        this.deptNm = data.getDeptNm();
        this.deptCd = data.getDeptCd();
        this.email = data.getEmail();
        this.birthYmd = data.getBirthYmd();
        this.handphone = data.getHandphone();
        this.postNm = data.getPostNm();
        this.hireYmd =  data.getHireYmd();
    }

    public AuthorityRequestResponse(AuthorityRequestPageDto data) {
        this.userAuthorityRequestSeq = data.getUserAuthorityRequestSeq();
        this.requestLevel = data.getRequestLevel();
        this.requestPeriodStart = data.getRequestPeriodStart();
        this.requestPeriodEnd = data.getRequestPeriodEnd();
        this.requestStatus = data.getRequestStatus();
        this.requestReason = data.getRequestReason();
        this.empNm = data.getEmpNm();
        this.empNo = data.getEmpNo();
        this.deptNm = data.getDeptNm();
        this.deptCd = data.getDeptCd();
        this.email = data.getEmail();
        this.birthYmd = data.getBirthYmd();
        this.handphone = data.getHandphone();
        this.postNm = data.getPostNm();
        this.hireYmd = data.getHireYmd();
    }
}


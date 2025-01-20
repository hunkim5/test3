package com.airpremia.eosh.authoritymanagement.authorityrequest.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestUpdateRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestPageDto {

    private Long userAuthorityRequestSeq;

    private String userId;

    private AuthorityManagementUserGradeEnum requestLevel;

    private LocalDate requestPeriodStart;

    private LocalDate requestPeriodEnd;

    private String requestReason;

    private RequestStatusEnum requestStatus;

    private String insertUserId;

    private String insertIp;


    private String empNo;

    private String empNm;

    private String deptNm;

    private String deptCd;

    private String email;

    private String handphone;

    private LocalDate birthYmd;

    private String postNm;

    private LocalDate hireYmd;

    public AuthorityRequestPageDto(AuthorityRequestUpdateRequest dto) {
        this.requestLevel = dto.getRequestLevel();
        this.requestPeriodStart = dto.getRequestPeriodStart();
        this.requestPeriodEnd = dto.getRequestPeriodEnd();
        this.requestReason = dto.getRequestReason();
        this.requestStatus = dto.getRequestStatus();
    }

}


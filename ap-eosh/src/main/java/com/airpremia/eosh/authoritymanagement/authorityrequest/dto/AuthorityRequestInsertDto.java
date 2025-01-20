package com.airpremia.eosh.authoritymanagement.authorityrequest.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestInsertRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestInsertDto {

    private Long userAuthorityRequestSeq;

    private long userSeq;

    private AuthorityManagementUserGradeEnum requestLevel;

    private LocalDate requestPeriodStart;

    private LocalDate requestPeriodEnd;

    private String requestReason;

    private RequestStatusEnum requestStatus;

    private String insertUserId;

    private String insertIp;

    private String updateUserId;

    private String updateIp;

    public AuthorityRequestInsertDto(AuthorityRequestInsertRequest dto) {
        this.requestLevel = dto.getRequestLevel();
        this.requestPeriodStart = dto.getRequestPeriodStart();
        this.requestPeriodEnd = dto.getRequestPeriodEnd();
        this.requestReason = dto.getRequestReason();
        this.requestStatus = dto.getRequestStatus();
    }
}


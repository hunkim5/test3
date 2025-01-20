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
public class AuthorityRequestUpdateDto {

    private Long userAuthorityRequestSeq;

    private AuthorityManagementUserGradeEnum requestLevel;

    private LocalDate requestPeriodStart;

    private LocalDate requestPeriodEnd;

    private String requestReason;

    private RequestStatusEnum requestStatus;

    private String updateUserId;

    private String updateIp;

    public AuthorityRequestUpdateDto(AuthorityRequestUpdateRequest req) {
        this.userAuthorityRequestSeq = req.getUserAuthorityRequestSeq();
        this.requestLevel = req.getRequestLevel();
        this.requestPeriodStart = req.getRequestPeriodStart();
        this.requestPeriodEnd = req.getRequestPeriodEnd();
        this.requestReason = req.getRequestReason();
        this.requestStatus = req.getRequestStatus();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }
}


package com.airpremia.eosh.authoritymanagement.authorityrequest.dto;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestSearchDto {
    private AuthorityManagementUserGradeEnum requestLevel;
    private LocalDate requestPeriodStart;
    private LocalDate requestPeriodEnd;
    private String requestReason;
    private RequestStatusEnum requestStatus;
    private String deptNm;
    private String empNm;
    private Long userSeq;
    private String userId;
    private String gubun;
    private List<String> empNoList;

    public AuthorityRequestSearchDto(AuthorityRequestSearchRequest dto) {
        this.requestLevel = dto.getRequestLevel();
        this.requestPeriodStart = dto.getRequestPeriodStart();
        this.requestPeriodEnd = dto.getRequestPeriodEnd();
        this.requestReason = dto.getRequestReason();
        this.requestStatus = dto.getRequestStatus();
        this.deptNm = dto.getDeptNm();
        this.empNm = dto.getEmpNm();
        this.gubun = dto.getGubun();
        this.empNoList = dto.getEmpNoList();
    }


}


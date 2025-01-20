package com.airpremia.eosh.authoritymanagement.authorityrequest.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.RequestStatusEnum;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestResponse;
import com.airpremia.eosh.authoritymanagement.authorityrequest.controller.AuthorityRequestUpdateRequest;
import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityRequestDto {

    private Long userAuthorityRequestSeq;
    private AuthorityManagementUserGradeEnum requestLevel;
    private LocalDate requestPeriodStart;
    private LocalDate requestPeriodEnd;
    private String requestReason;
    private String userId;
    private RequestStatusEnum requestStatus;
    private String empNo;
    private String empNm;
    private String deptNm;
    private String deptCd;
    private String email;
    private String handphone;
    private LocalDate birthYmd;
    private String postNm;
    private LocalDate hireYmd;

    public AuthorityRequestDto(AuthorityRequestUpdateRequest dto) {
        this.requestLevel = dto.getRequestLevel();
        this.requestPeriodStart = dto.getRequestPeriodStart();
        this.requestPeriodEnd = dto.getRequestPeriodEnd();
        this.requestReason = dto.getRequestReason();
        this.requestStatus = dto.getRequestStatus();
    }

    public AuthorityRequestResponse convertAuthorityRequestResponse() {
        AuthorityRequestResponse res = new AuthorityRequestResponse();
        res.setUserAuthorityRequestSeq(this.userAuthorityRequestSeq);
        res.setRequestLevel(this.requestLevel);
        res.setRequestPeriodStart(this.requestPeriodStart);
        res.setRequestPeriodEnd(this.requestPeriodEnd);
        res.setRequestReason(this.requestReason);
        res.setRequestStatus(this.requestStatus);

        res.setEmpNm(this.empNm);
        res.setEmpNo(this.empNo);
        res.setDeptNm(this.deptNm);
        res.setDeptCd(this.deptCd);
        res.setEmail(this.email);
        res.setBirthYmd(this.birthYmd);
        res.setHandphone(this.handphone);
        res.setPostNm(this.postNm);
        return res;
    }

    public AuthorityRequestResponse mergeHrInfo(AuthorityRequestDto authorityRequestDto, HrEmpDto hrData) {
        if (authorityRequestDto == null) {
            authorityRequestDto = new AuthorityRequestDto();
        } else {
            authorityRequestDto.setEmpNm(hrData.getEmpNm());
            authorityRequestDto.setDeptNm(hrData.getDeptNm());
            authorityRequestDto.setEmail(hrData.getEmail());
            authorityRequestDto.setHandphone(hrData.getHandphone());
            authorityRequestDto.setBirthYmd(hrData.getBirthYmd());
            authorityRequestDto.setPostNm(hrData.getPostNm());
        }
        return authorityRequestDto.convertAuthorityRequestResponse();
    }

    public void mergeInfo(AuthorityRequestDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setEmail(empDto.getEmail());
        dto.setPostNm(empDto.getPostNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setHandphone(empDto.getHandphone());
        dto.setHireYmd(empDto.getHireYmd());
    }
}


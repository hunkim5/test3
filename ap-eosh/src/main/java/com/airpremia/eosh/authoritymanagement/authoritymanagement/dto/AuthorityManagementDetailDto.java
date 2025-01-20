package com.airpremia.eosh.authoritymanagement.authoritymanagement.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementDetailResponse;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementDetailDto {

    private String userId;
    private AuthorityManagementUserGradeEnum userGradeEnum;
    private String empNm;
    private String email;
    private String handphone;
    private String postNm;
    private String deptNm;
    private LocalDate birthYmd;
    private LocalDate hireYmd;

    public AuthorityManagementDetailDto(HrEmpDto hrEmpDto) {
        this.empNm = hrEmpDto.getEmpNm();
        this.deptNm = hrEmpDto.getDeptNm();
        this.email = hrEmpDto.getEmail();
        this.handphone = hrEmpDto.getHandphone();
        this.birthYmd = hrEmpDto.getBirthYmd();
        this.postNm = hrEmpDto.getPostNm();
    }

    public AuthorityManagementDetailResponse convertAuthorityManagementDetailResponse() {
        AuthorityManagementDetailResponse response = new AuthorityManagementDetailResponse();
        response.setEmpNm(this.empNm);
        response.setDeptNm(this.deptNm);
        response.setEmail(this.email);
        response.setPostNm(this.postNm);
        response.setUserId(this.userId);
        response.setBirthYmd(this.birthYmd);
        response.setHandphone(this.handphone);
        response.setHireYmd(this.hireYmd);
        response.setUserGradeEnum(this.userGradeEnum);
        return response;
    }
}


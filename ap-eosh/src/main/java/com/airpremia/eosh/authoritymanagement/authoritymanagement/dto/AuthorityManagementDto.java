package com.airpremia.eosh.authoritymanagement.authoritymanagement.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityManagementDto {

    private String userId;
    private String safetyOfficeCode;
    private AuthorityManagementUserGradeEnum userGradeEnum;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;
    private String empNo;
    private String empNm;
    private String email;
    private String handphone;
    private String postNm;
    private String deptNm;
    private LocalDate birthYmd;
    private LocalDate hireYmd;

    public void mergeInfo(HrEmpDto empDto) {
        this.empNm = empDto.getEmpNm();
        this.deptNm = empDto.getDeptNm();
        this.email = empDto.getEmail();
        this.postNm = empDto.getPostNm();
        this.birthYmd = empDto.getBirthYmd();
        this.handphone = empDto.getHandphone();
        this.hireYmd = empDto.getHireYmd();
    }
}


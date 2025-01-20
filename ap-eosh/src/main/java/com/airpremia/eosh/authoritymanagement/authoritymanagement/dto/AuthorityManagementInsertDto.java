package com.airpremia.eosh.authoritymanagement.authoritymanagement.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementInsertDto {


    private String userId;

    private AuthorityManagementUserGradeEnum userGradeEnum;

    private String deptCd;

    private String insertUserId;

    private String insertIp;

    private LocalDateTime insertDtm;

    public AuthorityManagementInsertDto(HrEmpDto dto) {
        this.userId = dto.getEmpNo().substring(1) + dto.getBirthYmd().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.userGradeEnum = AuthorityManagementUserGradeEnum.LEVEL4;
        this.deptCd = dto.getDeptCd();
    }
}


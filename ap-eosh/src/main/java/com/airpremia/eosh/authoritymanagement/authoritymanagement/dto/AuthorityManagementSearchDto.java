package com.airpremia.eosh.authoritymanagement.authoritymanagement.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementSearchDto {

    private AuthorityManagementUserGradeEnum userGradeEnum;


    private String empNm;

    private String email;

    private String handphone;

    private String postNm;

    private String deptNm;

    private LocalDate birthYmd;

    private LocalDate hireYmd;

    public AuthorityManagementSearchDto convertAuthorityManagementSearchDto() {
        AuthorityManagementSearchDto dto = new AuthorityManagementSearchDto();
        dto.setUserGradeEnum(this.userGradeEnum);
        dto.setEmpNm(this.empNm);
        dto.setDeptNm(this.deptNm);
        dto.setEmail(this.email);
        dto.setPostNm(this.postNm);
        dto.setBirthYmd(this.birthYmd);
        dto.setHandphone(this.handphone);
        dto.setHireYmd(this.hireYmd);
        return dto;
    }
}


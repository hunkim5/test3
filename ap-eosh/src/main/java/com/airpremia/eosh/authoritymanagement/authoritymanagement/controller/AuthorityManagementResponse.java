package com.airpremia.eosh.authoritymanagement.authoritymanagement.controller;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementResponse {
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 등급 ENUM")
    private AuthorityManagementUserGradeEnum userGradeEnum;

    @Schema(description = "사용자 번호")
    private String empNo;
    @Schema(description = "사용자 이름")
    private String empNm;
    @Schema(description = "사용자 이메일")
    private String email;
    @Schema(description = "사용자 핸드폰번호")
    private String handphone;
    @Schema(description = "사용자 직책")
    private String postNm;
    @Schema(description = "사용자 부서명")
    private String deptNm;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사용자 입사일")
    private LocalDate hireYmd;

    public AuthorityManagementResponse(AuthorityManagementDto req) {
        this.userId = req.getUserId();
        this.userGradeEnum = req.getUserGradeEnum();
        this.empNo = req.getEmpNo();
        this.empNm = req.getEmpNm();
        this.email = req.getEmail();
        this.handphone = req.getHandphone();
        this.postNm = req.getPostNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.hireYmd = req.getHireYmd();
    }
}


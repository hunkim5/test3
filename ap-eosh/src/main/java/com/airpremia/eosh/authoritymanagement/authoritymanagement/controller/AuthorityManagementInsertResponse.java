package com.airpremia.eosh.authoritymanagement.authoritymanagement.controller;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementInsertDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementInsertResponse {
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 등급 ENUM")
    private AuthorityManagementUserGradeEnum userGradeEnum;
    @Schema(description = "사용자 부서")
    private String deptCd;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 아이피")
    private String insertIp;

    public AuthorityManagementInsertResponse(AuthorityManagementInsertDto dto) {
        this.userId = dto.getUserId();
        this.userGradeEnum = dto.getUserGradeEnum();
        this.deptCd = dto.getDeptCd();
        this.insertUserId = dto.getInsertUserId();
        this.insertIp = dto.getInsertIp();
    }
}


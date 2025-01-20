package com.airpremia.eosh.authoritymanagement.authoritymanagement.entities;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AuthorityManagementEntity {
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "안전 직책 코드")
    private String safetyOfficeCode;
    @Schema(description = "사용자 등급 ENUM")
    private AuthorityManagementUserGradeEnum userGradeEnum;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "사번")
    private String empNo;
}

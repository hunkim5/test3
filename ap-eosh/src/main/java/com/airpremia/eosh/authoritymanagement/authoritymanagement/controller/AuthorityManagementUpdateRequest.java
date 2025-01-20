package com.airpremia.eosh.authoritymanagement.authoritymanagement.controller;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.dto.AuthorityManagementUpdateDto;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementUpdateRequest {
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 등급 ENUM")
    private AuthorityManagementUserGradeEnum userGradeEnum;

    public AuthorityManagementUpdateDto convertAuthorityManagementUpdateDto() {
        AuthorityManagementUpdateDto dto = new AuthorityManagementUpdateDto();
        dto.setUserId(this.userId);
        dto.setUserGradeEnum(this.userGradeEnum);
        dto.setUpdateUserId("test");
        dto.setUpdateIp("test");
        return dto;
    }
}


package com.airpremia.eosh.authoritymanagement.authoritymanagement.dto;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.controller.AuthorityManagementUpdateRequest;
import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementUpdateDto {

    private String userId;

    private AuthorityManagementUserGradeEnum userGradeEnum;

    private String updateUserId;

    private String updateIp;

    public AuthorityManagementUpdateDto(AuthorityManagementUpdateRequest dto) {
        this.userId = dto.getUserId();
        this.userGradeEnum = dto.getUserGradeEnum();
    }
}


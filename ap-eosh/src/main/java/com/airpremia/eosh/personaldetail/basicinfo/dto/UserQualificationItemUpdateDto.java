package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemUpdateRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemUpdateResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserQualificationItemUpdateDto {

    private String attachFileUuid;

    private String insertUserId;

    private String qualificationCode;

    private LocalDate qualificationExpirationDt;

    private String userId;

    public UserQualificationItemUpdateDto(UserQualificationItemUpdateRequest request) {
        this.userId = request.getUserId();
        this.qualificationCode = request.getQualificationCode();
        this.qualificationExpirationDt = request.getQualificationExpirationDt();
        this.attachFileUuid = request.getAttachFileUuid();
    }

    public UserQualificationItemUpdateResponse convertUserqualificationitemInsertResponse() {
        UserQualificationItemUpdateResponse response = new UserQualificationItemUpdateResponse();
        response.setUserId(this.userId);
        response.setQualificationCode(this.qualificationCode);
        response.setQualificationExpirationDt(this.qualificationExpirationDt);
        response.setAttachFileUuid(this.attachFileUuid);

        return response;
    }
}


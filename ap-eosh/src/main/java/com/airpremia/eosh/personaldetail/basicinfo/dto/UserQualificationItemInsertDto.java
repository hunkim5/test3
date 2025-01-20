package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemInsertRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemInsertResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserQualificationItemInsertDto {

    private String attachFileUuid;

    private String qualificationCode;

    private LocalDate qualificationExpirationDt;

    private String userId;

    public UserQualificationItemInsertDto(UserQualificationItemInsertRequest request) {
        this.userId = request.getUserId();
        this.qualificationCode = request.getQualificationCode();
        this.qualificationExpirationDt = request.getQualificationExpirationDt();
        this.attachFileUuid = request.getAttachFileUuid();

    }

    public UserQualificationItemInsertResponse convertUserqualificationitemInsertResponse() {
        UserQualificationItemInsertResponse response = new UserQualificationItemInsertResponse();
        response.setUserId(this.userId);
        response.setQualificationCode(this.qualificationCode);
        response.setQualificationExpirationDt(this.qualificationExpirationDt);
        response.setAttachFileUuid(this.attachFileUuid);

        return response;
    }
}


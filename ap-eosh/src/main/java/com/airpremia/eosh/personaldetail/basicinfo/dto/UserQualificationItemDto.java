package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserQualificationItemDto {
    private Long userQualificationItemSeq;
    private String qualificationCode;
    private Long userSeq;
    private String userId;
    private LocalDate qualificationExpirationDt;
    private String attachFileUuid;
    private LocalDateTime insertDtm;
    private String insertUserId;
    private String insertIp;
    private LocalDateTime updateDtm;
    private String updateUserId;
    private String updateIp;

    public UserQualificationItemDto(UserQualificationItemRequest request) {
        this.userQualificationItemSeq = request.getUserQualificationItemSeq();
        this.userSeq = request.getUserSeq();
        this.userId = request.getUserId();
        this.qualificationCode = request.getQualificationCode();
        this.qualificationExpirationDt = request.getQualificationExpirationDt();
        this.attachFileUuid = request.getAttachFileUuid();
    }

    public UserQualificationItemResponse convertUserqualificationitemSearchResponse() {
        UserQualificationItemResponse response = new UserQualificationItemResponse();
        response.setQualificationCode(this.qualificationCode);
        response.setQualificationExpirationDt(this.qualificationExpirationDt);
        response.setAttachFileUuid(this.attachFileUuid);

        return response;
    }

    public UserQualificationItemResponse convertUserQualificationItemResponse() {
        UserQualificationItemResponse response = new UserQualificationItemResponse();
        response.setQualificationCode(this.qualificationCode);
        response.setQualificationExpirationDt(this.qualificationExpirationDt);
        response.setAttachFileUuid(this.attachFileUuid);
        return response;
    }
}


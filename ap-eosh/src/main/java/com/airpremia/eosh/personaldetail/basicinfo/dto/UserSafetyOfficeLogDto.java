package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSafetyOfficeLogDto {
    private Long userSafetyOfficeLogSeq;
    private Long userSeq;
    private String safetyOfficeClassificationCode;
    private LocalDate appointDt;
    private LocalDate dismissDt;
    private LocalDateTime insertDtm;
    private String insertUserId;
    private String insertIp;
    private LocalDateTime updateDtm;
    private String updateUserId;
    private String updateIp;

    public UserSafetyOfficeLogDto(UserSafetyOfficeLogRequest request) {
        this.userSeq = request.getUserSeq();
        this.userSafetyOfficeLogSeq = request.getUserSafetyOfficeLogSeq();
        this.safetyOfficeClassificationCode = request.getSafetyOfficeClassificationCode();
        this.appointDt = request.getAppointDt();
        this.dismissDt = request.getDismissDt();
    }

    public UserSafetyOfficeLogResponse convertUserSafetyOfficeLogSearchResponse() {
        UserSafetyOfficeLogResponse response = new UserSafetyOfficeLogResponse();
        response.setUserSafetyOfficeLogSeq(this.userSafetyOfficeLogSeq);
        response.setSafetyOfficeClassificationCode(this.safetyOfficeClassificationCode);
        response.setAppointDt(this.appointDt);
        response.setDismissDt(this.dismissDt);
        return response;
    }
}


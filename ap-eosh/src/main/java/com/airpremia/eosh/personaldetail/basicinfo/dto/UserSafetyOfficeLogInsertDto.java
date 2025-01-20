package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogInsertResponse;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSafetyOfficeLogInsertDto {

    private Long userSafetyOfficeLogSeq;

    private Long userSeq;

    private String safetyOfficeClassificationCode;

    private LocalDate appointDt;

    private LocalDate dismissDt;

    private String insertUserId;

    private LocalDateTime insertDtm;

    private String insertIp;

    public UserSafetyOfficeLogInsertDto(UserSafetyOfficeLogRequest request) {
        this.userSafetyOfficeLogSeq = request.getUserSafetyOfficeLogSeq();
        this.userSeq = request.getUserSeq();
        this.safetyOfficeClassificationCode = request.getSafetyOfficeClassificationCode();
        this.appointDt = request.getAppointDt();
        this.dismissDt = request.getDismissDt();

        this.insertIp = "1.1.1";
        this.insertUserId = "testId";
    }

    public UserSafetyOfficeLogInsertResponse convertUserSafetyOfficeLogInsertResponse() {
        UserSafetyOfficeLogInsertResponse response = new UserSafetyOfficeLogInsertResponse();
        response.setUserSafetyOfficeLogSeq(this.userSafetyOfficeLogSeq);
        response.setUserSeq(this.userSeq);
        response.setSafetyOfficeClassificationCode(this.safetyOfficeClassificationCode);
        response.setAppointDt(this.appointDt);
        response.setDismissDt(this.dismissDt);

        return response;
    }
}


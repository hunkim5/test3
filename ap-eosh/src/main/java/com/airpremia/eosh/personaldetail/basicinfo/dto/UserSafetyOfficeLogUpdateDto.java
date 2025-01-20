package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogUpdateRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserSafetyOfficeLogUpdateResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSafetyOfficeLogUpdateDto {

    private Long userSafetyOfficeLogSeq;

    private String userId;

    private String safetyOfficeClassificationCode;

    private LocalDate appointDt;

    private LocalDate dismissDt;

    public UserSafetyOfficeLogUpdateDto(UserSafetyOfficeLogUpdateRequest request) {
        this.userSafetyOfficeLogSeq = request.getUserSafetyOfficeLogSeq();
        this.userId = request.getUserId();
        this.safetyOfficeClassificationCode = request.getSafetyOfficeClassificationCode();
        this.appointDt = request.getAppointDt();
        this.dismissDt = request.getDismissDt();
    }

    public UserSafetyOfficeLogUpdateResponse convertUserSafetyOfficeLogUpdateResponse() {
        UserSafetyOfficeLogUpdateResponse response = new UserSafetyOfficeLogUpdateResponse();
        response.setUserSafetyOfficeLogSeq(this.userSafetyOfficeLogSeq);
        response.setUserId(this.userId);
        response.setSafetyOfficeClassificationCode(this.safetyOfficeClassificationCode);
        response.setAppointDt(this.appointDt);
        response.setDismissDt(this.dismissDt);
        return response;
    }
}


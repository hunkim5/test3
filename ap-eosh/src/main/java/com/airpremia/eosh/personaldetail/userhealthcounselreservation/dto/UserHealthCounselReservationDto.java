package com.airpremia.eosh.personaldetail.userhealthcounselreservation.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.userhealthcounselreservation.controller.UserHealthCounselReservationRequest;
import com.airpremia.eosh.personaldetail.userhealthcounselreservation.enums.HealthCounselAppvalprcEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserHealthCounselReservationDto {

    private Long userHealthCounselReservationSeq;
    private String counselReservationUserId;
    private String counselReservationUserName;
    private String counselReservationDepartmentId;
    private String counselReservationDepartmentName;
    private String handphoneNo;
    private HealthCounselAppvalprcEnum healthCounselAppvalprcEnum;
    private String healthCounselClassificationCode;
    private LocalDateTime reservationDtm;
    private String healthCounselSubject;
    private String healthCounselContent;
    private String rejectReason;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public UserHealthCounselReservationDto(UserHealthCounselReservationRequest req) {
        this.userHealthCounselReservationSeq = req.getUserHealthCounselReservationSeq();
        this.counselReservationUserId = req.getCounselReservationUserId();
        this.counselReservationUserName = req.getCounselReservationUserName();
        this.counselReservationDepartmentId = req.getCounselReservationDepartmentId();
        this.counselReservationDepartmentName = req.getCounselReservationDepartmentName();
        this.handphoneNo = req.getHandphoneNo();
        this.healthCounselAppvalprcEnum = req.getHealthCounselAppvalprcEnum();
        this.healthCounselClassificationCode = req.getHealthCounselClassificationCode();
        this.reservationDtm = req.getReservationDtm();
        this.healthCounselSubject = req.getHealthCounselSubject();
        this.healthCounselContent = req.getHealthCounselContent();
        this.rejectReason = req.getRejectReason();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }
}


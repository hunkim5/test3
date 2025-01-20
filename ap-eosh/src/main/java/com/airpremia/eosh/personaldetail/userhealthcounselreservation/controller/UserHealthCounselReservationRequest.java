package com.airpremia.eosh.personaldetail.userhealthcounselreservation.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.userhealthcounselreservation.enums.HealthCounselAppvalprcEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserHealthCounselReservationRequest {

    @Schema(description = "사용자 보건 상담 예약 시퀀스")
    private Long userHealthCounselReservationSeq;
    @Schema(description = "상담 예약 사용자 아이디")
    private String counselReservationUserId;
    @Schema(description = "상담 예약 사용자 이름")
    private String counselReservationUserName;
    @Schema(description = "상담 예약 부서 아이디")
    private String counselReservationDepartmentId;
    @Schema(description = "상담 예약 부서 이름")
    private String counselReservationDepartmentName;
    @Schema(description = "핸드폰 번호")
    private String handphoneNo;
    @Schema(description = "보건 상담 승인절차 ENUM")
    private HealthCounselAppvalprcEnum healthCounselAppvalprcEnum;
    @Schema(description = "보건 상담 분류 코드")
    private String healthCounselClassificationCode;
    @Schema(description = "예약 일시")
    private LocalDateTime reservationDtm;
    @Schema(description = "보건 상담 제목")
    private String healthCounselSubject;
    @Schema(description = "보건 상담 내용")
    private String healthCounselContent;
    @Schema(description = "반려 사유")
    private String rejectReason;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;

}


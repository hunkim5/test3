package com.airpremia.eosh.health.healthcounselresult.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.authoritymanagement.user.enums.Sex;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserHealthCounselResultRequest {

    @Schema(description = "사용자 보건 상담 결과 시퀀스")
    private Long userHealthCounselResultSeq;
    @Schema(description = "사용자 보건 상담 예약 시퀀스")
    private Long userHealthCounselReservationSeq;
    @Schema(description = "상담 일자")
    private LocalDate counselDt;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "상담 대상 사용자 아이디")
    private String counselTargetUserId;
    @Schema(description = "상담 대상 사용자 이름")
    private String counselTargetUserName;
    @Schema(description = "상담 대상 부서 아이디")
    private String counselTargetDepartmentId;
    @Schema(description = "상담 대상 부서 이름")
    private String counselTargetDepartmentName;
    @Schema(description = "생년월일")
    private LocalDate birthDt;
    @Schema(description = "성별")
    private Sex sex;
    @Schema(description = "입사일")
    private LocalDate hireDt;
    @Schema(description = "교대 여부")
    private boolean shiftBool;
    @Schema(description = "연락처")
    private String contact;
    @Schema(description = "일반 특수 여부")
    private boolean normalSpecialBool;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "유해인자")
    private String hazardAgent;
    @Schema(description = "건강 구분")
    private String healthDivision;
    @Schema(description = "검진 comment")
    private String examinationComment;
    @Schema(description = "사후 관리 comment")
    private String postmortemManageComment;
    @Schema(description = "업무 수행 적합 여부")
    private boolean workPerformSuitableBool;
    @Schema(description = "기타")
    private String etc;
    @Schema(description = "과거 이력")
    private String pastHistrory;
    @Schema(description = "특이사항")
    private String specialNote;
    @Schema(description = "키")
    private String height;
    @Schema(description = "체중")
    private int weight;
    @Schema(description = "BMI")
    private int bmi;
    @Schema(description = "혈압")
    private String bloodpressure;
    @Schema(description = "음주")
    private String drinking;
    @Schema(description = "흡연")
    private String smoking;
    @Schema(description = "운동")
    private String exercise;
    @Schema(description = "수면")
    private String sleep;
    @Schema(description = "상담 내용")
    private String counselContent;
    @Schema(description = "확인")
    private String check;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
}

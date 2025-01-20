package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserCerebrocardiovascularExaminationResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사번")
    private String empNo;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "근무 구분 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "'위험군분류' code")
    private String riskGroupClassificationCode;
    @Schema(description = "검진 기록 내용")
    private String examinationRecordContent;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
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

    public UserCerebrocardiovascularExaminationResponse(UserCerebrocardiovascularExaminationPageDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.empNm = req.getEmpNm();
        this.empNo = req.getEmpNo();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.standardYyyy = req.getStandardYyyy();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.examinationDt = req.getExaminationDt();
        this.riskGroupClassificationCode = req.getRiskGroupClassificationCode();
        this.examinationRecordContent = req.getExaminationRecordContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
    }

    public UserCerebrocardiovascularExaminationResponse(UserCerebrocardiovascularExaminationDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.examinationDt = req.getExaminationDt();
        this.riskGroupClassificationCode = req.getRiskGroupClassificationCode();
        this.examinationRecordContent = req.getExaminationRecordContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
    }
}


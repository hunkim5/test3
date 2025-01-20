package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserSpecialExaminationDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSpecialExaminationResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "근무 구분 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "'특수검진' comment")
    private String specialExamComment;
    @Schema(description = "'특수검진' 날짜")
    private LocalDate specialExamDt;
    @Schema(description = "검진 결과 내용")
    private String examinationResultContent;
    @Schema(description = "외부 검진 기록 내용")
    private String externalExaminationRecordContent;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사번")
    private String empNo;

    public UserSpecialExaminationResponse(UserSpecialExaminationDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.examinationDt = req.getExaminationDt();
        this.specialExamComment = req.getSpecialExamComment();
        this.specialExamDt = req.getSpecialExamDt();
        this.examinationResultContent = req.getExaminationResultContent();
        this.externalExaminationRecordContent = req.getExternalExaminationRecordContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.empNo = req.getEmpNo();
    }
}


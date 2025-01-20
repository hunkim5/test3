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
public class UserSpecialExaminationRequest {
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


    public UserSpecialExaminationDto convertUserSpecialExaminationDto() {
        UserSpecialExaminationDto data = new UserSpecialExaminationDto();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setExaminationDt(this.examinationDt);
        data.setSpecialExamComment(this.specialExamComment);
        data.setSpecialExamDt(this.specialExamDt);
        data.setExaminationResultContent(this.examinationResultContent);
        data.setExternalExaminationRecordContent(this.externalExaminationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }

    public UserSpecialExaminationResponse convertUserSpecialExaminationResponse() {
        UserSpecialExaminationResponse data = new UserSpecialExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setExaminationDt(this.examinationDt);
        data.setSpecialExamComment(this.specialExamComment);
        data.setSpecialExamDt(this.specialExamDt);
        data.setExaminationResultContent(this.examinationResultContent);
        data.setExternalExaminationRecordContent(this.externalExaminationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }
}


package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCerebrocardiovascularExaminationRequest {
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
    @Schema(description = "'위험군분류' Code")
    private String riskGroupClassificationCode;
    @Schema(description = "검진 기록 내용")
    private String examinationRecordContent;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;

    public UserCerebrocardiovascularExaminationDto convertUserCerebrocardiovascularExaminationDto() {
        UserCerebrocardiovascularExaminationDto data = new UserCerebrocardiovascularExaminationDto();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setEmpNm(this.empNm);
        data.setDeptNm(this.deptNm);
        data.setBirthYmd(this.birthYmd);
        data.setEmpNo(this.empNo);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setExaminationDt(this.examinationDt);
        data.setRiskGroupClassificationCode(this.riskGroupClassificationCode);
        data.setExaminationRecordContent(this.examinationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }

    public UserCerebrocardiovascularExaminationResponse convertUserCerebrocardiovascularExaminationResponse() {
        UserCerebrocardiovascularExaminationResponse data = new UserCerebrocardiovascularExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setExaminationDt(this.examinationDt);
        data.setRiskGroupClassificationCode(this.riskGroupClassificationCode);
        data.setRiskGroupClassificationCode(this.riskGroupClassificationCode);
        data.setExaminationRecordContent(this.examinationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }
}


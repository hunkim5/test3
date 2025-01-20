package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoSearchRequest;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationPageDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNormalExaminationResponse {
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
    @Schema(description = "'구강검진' 여부 코드")
    private String oralExamBoolCode;
    @Schema(description = "'위암' 여부 코드")
    private String stomachCancerBoolCode;
    @Schema(description = "'유방암' 여부 코드")
    private String breastCancerBoolCode;
    @Schema(description = "'대장암' 여부 코드")
    private String colonCancerBoolCode;
    @Schema(description = "'자궁경부암' 여부 코드")
    private String cervicalCancerBoolCode;
    @Schema(description = "일반검진 코드")
    private String normalExaminationCode;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "비고")
    private String remark;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "부서 코드")
    private String deptCd;
    @Schema(description = "사용자 입사일")
    private LocalDate hireYmd;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사용자 이메일")
    private String email;
    @Schema(description = "사용자 핸드폰번호")
    private String handphone;
    @Schema(description = "사번")
    private String empNo;

    public UserNormalExaminationResponse(UserNormalExaminationPageDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.examinationDt = req.getExaminationDt();
        this.normalExaminationCode = req.getNormalExaminationCode();
        this.oralExamBoolCode = req.getOralExamBoolCode();
        this.stomachCancerBoolCode = req.getStomachCancerBoolCode();
        this.breastCancerBoolCode = req.getBreastCancerBoolCode();
        this.colonCancerBoolCode = req.getColonCancerBoolCode();
        this.cervicalCancerBoolCode = req.getCervicalCancerBoolCode();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.empNo = req.getEmpNo();
    }

    public UserNormalExaminationResponse(BasicInfoSearchRequest req) {
        this.userId = req.getUserId();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
    }
}


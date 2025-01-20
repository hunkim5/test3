package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNormalExaminationRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 부서 코드")
    private String deptCd;
    @Schema(description = "사용자 부서")
    private String deptNm;
    @Schema(description = "사용자 직급")
    private String postNm;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "근무 구분 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "'일반검진' 여부 코드")
    private String normalExaminationCode;
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
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "비고")
    private String remark;


    public UserNormalExaminationDto convertUserNormalExaminationDto() {
        UserNormalExaminationDto data = new UserNormalExaminationDto();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setPostNm(this.postNm);
        data.setDeptCd(this.deptCd);
        data.setDeptNm(this.deptNm);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setExaminationDt(this.examinationDt);
        data.setOralExamBoolCode(ExaminationCodeEnum.valueOf(this.oralExamBoolCode));
        data.setStomachCancerBoolCode(ExaminationCodeEnum.valueOf(this.stomachCancerBoolCode));
        data.setBreastCancerBoolCode(ExaminationCodeEnum.valueOf(this.breastCancerBoolCode));
        data.setNormalExaminationCode(ExaminationCodeEnum.valueOf(this.normalExaminationCode));
        data.setColonCancerBoolCode(ExaminationCodeEnum.valueOf(this.colonCancerBoolCode));
        data.setCervicalCancerBoolCode(ExaminationCodeEnum.valueOf(this.cervicalCancerBoolCode));
        data.setMultipleFileUuid(this.multipleFileUuid);
        data.setRemark(this.remark);
        return data;
    }

    public UserNormalExaminationResponse convertUserNormalExaminationResponse() {
        UserNormalExaminationResponse data = new UserNormalExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setExaminationDt(this.examinationDt);
        data.setOralExamBoolCode(this.oralExamBoolCode);
        data.setStomachCancerBoolCode(this.stomachCancerBoolCode);
        data.setBreastCancerBoolCode(this.breastCancerBoolCode);
        data.setColonCancerBoolCode(this.colonCancerBoolCode);
        data.setCervicalCancerBoolCode(this.cervicalCancerBoolCode);
        data.setNormalExaminationCode(this.normalExaminationCode);
        data.setMultipleFileUuid(this.multipleFileUuid);
        data.setRemark(this.remark);
        return data;
    }
}


package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNormalExaminationDto {
    private Long userSeq;
    private String userId;
    private String standardYyyy;
    private ExaminationStatusEnum examinationStatusEnum;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private LocalDate examinationDt;
    private ExaminationCodeEnum oralExamBoolCode;
    private ExaminationCodeEnum stomachCancerBoolCode;
    private ExaminationCodeEnum breastCancerBoolCode;
    private ExaminationCodeEnum colonCancerBoolCode;
    private ExaminationCodeEnum normalExaminationCode;
    private ExaminationCodeEnum cervicalCancerBoolCode;
    private String multipleFileUuid;
    private String remark;
    private String deptCd;
    private String deptNm;
    private String postNm;
    private String insertUserId;
    private String insertIp;
    private LocalDateTime insertDtm;


    public UserNormalExaminationDto(String userId, String year) {
        this.userId = userId;
        this.standardYyyy = year;
    }

    public UserNormalExaminationDto(Long userSeq, String year) {
        this.userSeq = userSeq;
        this.standardYyyy = year;
    }

    public UserNormalExaminationResponse convertUserNormalExaminationResponse() {
        UserNormalExaminationResponse data = new UserNormalExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setDeptCd(this.deptCd);
        data.setDeptNm(this.deptNm);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setExaminationDt(this.examinationDt);
        data.setOralExamBoolCode(String.valueOf(this.oralExamBoolCode));
        data.setStomachCancerBoolCode(String.valueOf(this.stomachCancerBoolCode));
        data.setRemark((this.remark));
        data.setNormalExaminationCode(String.valueOf(this.normalExaminationCode));
        data.setBreastCancerBoolCode(String.valueOf(this.breastCancerBoolCode));
        data.setColonCancerBoolCode(String.valueOf(this.colonCancerBoolCode));
        data.setCervicalCancerBoolCode(String.valueOf(this.cervicalCancerBoolCode));
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }

    public void setExaminationCodes(RealTimePublicNormalExaminationDto data) {
        this.normalExaminationCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getNormalExaminationCode()));
        this.oralExamBoolCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getOralExamBoolCode()));
        this.stomachCancerBoolCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getStomachCancerBoolCode()));
        this.breastCancerBoolCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getBreastCancerBoolCode()));
        this.colonCancerBoolCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getColonCancerBoolCode()));
        this.cervicalCancerBoolCode = ExaminationCodeEnum.valueOf(String.valueOf(data.getCervicalCancerBoolCode()));
    }
}

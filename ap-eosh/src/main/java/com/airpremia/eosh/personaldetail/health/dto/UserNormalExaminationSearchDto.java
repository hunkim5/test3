package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationSearchRequest;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserNormalExaminationSearchDto extends UserExaminationSearchDto {
    private Long userSeq;
    private String userId;
    private String empNo;
    private String empNm;
    private String deptNm;
    private LocalDate birthYmd;
    private String standardYyyy;
    private ExaminationStatusEnum examinationStatusEnum;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private LocalDate examinationDt;
    private String normalExaminationCode;
    private String oralExamBoolCode;
    private String stomachCancerBoolCode;
    private String breastCancerBoolCode;
    private String colonCancerBoolCode;
    private String cervicalCancerBoolCode;

    public UserNormalExaminationSearchDto(UserNormalExaminationSearchRequest req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.empNo = req.getEmpNo();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
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
    }
}


package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationRequest;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCerebrocardiovascularExaminationSearchDto extends UserExaminationSearchDto {
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
    private String riskGroupClassificationCode;
    private String examinationRecordContent;
    private String multipleFileUuid;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public UserCerebrocardiovascularExaminationSearchDto(UserCerebrocardiovascularExaminationRequest req) {
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
        this.riskGroupClassificationCode = req.getRiskGroupClassificationCode();
        this.examinationRecordContent = req.getExaminationRecordContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
    }
}


package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserCerebrocardiovascularExaminationDto {
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
    private String insertIp;
    private String insertUserId;
    private String updateIp;
    private String updateUserId;

    public UserCerebrocardiovascularExaminationResponse convertUserCerebrocardiovascularExaminationResponse() {
        UserCerebrocardiovascularExaminationResponse data = new UserCerebrocardiovascularExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setEmpNo(this.empNo);
        data.setEmpNm(this.empNm);
        data.setDeptNm(this.deptNm);
        data.setBirthYmd(this.birthYmd);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setExaminationDt(this.examinationDt);
        data.setRiskGroupClassificationCode(this.riskGroupClassificationCode);
        data.setExaminationRecordContent(this.examinationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }
}


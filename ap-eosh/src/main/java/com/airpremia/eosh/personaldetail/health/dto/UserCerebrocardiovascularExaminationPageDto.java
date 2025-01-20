package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCerebrocardiovascularExaminationPageDto extends UserExaminationPageDto {
    private Long userSeq;
    private String userId;
    private String empNm;
    private String deptNm;
    private LocalDate birthYmd;
    private String empNo;
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

    public void mergeInfo(UserCerebrocardiovascularExaminationPageDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setUserJobClassificationClassificationEnum(empDto.getUserJobClassificationClassificationEnum());
    }

}


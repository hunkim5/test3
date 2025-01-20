package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoSearchRequest;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNormalExaminationPageDto extends UserExaminationPageDto {
    private Long userSeq;
    private String userId;
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
    private String multipleFileUuid;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String empNm;
    private String deptNm;
    private LocalDate birthYmd;
    private String empNo;

    public UserNormalExaminationPageDto(BasicInfoSearchRequest req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
    }

    public void mergeInfo(UserNormalExaminationPageDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setUserJobClassificationClassificationEnum(empDto.getUserJobClassificationClassificationEnum());
    }
}


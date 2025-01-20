package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCosmicRadiationExaminationPageDto extends UserExaminationPageDto {

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
    private String hemoglobinComment;
    private String whiteBloodCellComment;
    private String plateletComment;
    private String diagnosisOpinionComment;
    private LocalDate leaveOfAbsenceDt;
    private LocalDate returnToWorkDt;
    private String reexaminationComment;
    private String multipleFileUuid;

    public void mergeInfo(UserCosmicRadiationExaminationPageDto dto, HrEmpDto empDto) {
        dto.setEmpNo(empDto.getEmpNo());
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setUserJobClassificationClassificationEnum(empDto.getUserJobClassificationClassificationEnum());
    }
}


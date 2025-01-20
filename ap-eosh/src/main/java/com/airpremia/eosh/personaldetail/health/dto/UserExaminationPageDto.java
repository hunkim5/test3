package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExaminationPageDto {
    private String userId;
    private String empNo;
    private String empNm;
    private String deptNm;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private LocalDate birthYmd;

    public void mergeInfo(UserExaminationPageDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setUserJobClassificationClassificationEnum(empDto.getUserJobClassificationClassificationEnum());
    }
}

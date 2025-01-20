package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.health.controller.HealthResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthPageDto {

    private Long userSeq;

    private String userId;

    private String standardYyyy;

    private String deptCd;

    private String deptNm;

    private String postNm;

    private String empNm;

    private ExaminationCodeEnum normalExaminationCode;

    private HealthResponse detailedHealth;

    private boolean userSpecialExamination;

    private boolean userCosmicRadiationExamination;

    private String userCerebrocardiovascularExamination;

    private int score;

    public void setHrInfo(HealthPageDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptCd(empDto.getDeptCd());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setPostNm(empDto.getPostNm());
    }

}


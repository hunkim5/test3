package com.airpremia.eosh.personaldetail.health.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthSearchDto {

    private Long userSeq;

    private String userId;

    private String standardYyyy;

    private String postNm;

    private String deptCd;

    private String deptNm;

    private String empNm;

    public String empNo;

    public String normalExaminationCode;

    private String riskGroupClassificationCode;

}


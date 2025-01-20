package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.personaldetail.health.dto.HealthSearchDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthSearchRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "직위")
    private String postNm;
    @Schema(description = "부서 code")
    private String deptCd;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "일반 검진 코드")
    private String normalExaminationCode;
    @Schema(description = "'위험군분류' Code")
    private String riskGroupClassificationCode;

    public HealthSearchDto convertHealthDto() {
        HealthSearchDto data = new HealthSearchDto();
        data.setUserId(this.userId);
        data.setStandardYyyy(this.standardYyyy);
        data.setPostNm(this.postNm);
        data.setDeptCd(this.deptCd);
        data.setDeptNm(this.deptNm);
        data.setEmpNm(this.empNm);
        data.setNormalExaminationCode(this.normalExaminationCode);
        data.setRiskGroupClassificationCode(this.riskGroupClassificationCode);
        return data;
    }
}


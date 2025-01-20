package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailFirstDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailSecondDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthCheckDetailResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "사번")
    private String empNo;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준년도")
    private String standardYyyy;
    private HealthCheckDetailFirstDto healthCheckDetailFirstDto;
    private HealthCheckDetailSecondDto healthCheckDetailSecondDto;

    public HealthCheckDetailResponse(
        HealthCheckDetailDto dto, HrEmpDto hrData) {
        if (dto.getHealthCheckDetailFirstDto() != null) {
            this.userSeq = dto.getHealthCheckDetailFirstDto().getUserSeq();
            this.empNm = hrData.getEmpNm();
            this.empNo = dto.getHealthCheckDetailFirstDto().getEmpNo();
            this.deptNm = hrData.getDeptNm();
            this.userId = dto.getHealthCheckDetailFirstDto().getUserId();
            this.standardYyyy = dto.getHealthCheckDetailFirstDto().getStandardYyyy();
            this.healthCheckDetailFirstDto = dto.getHealthCheckDetailFirstDto();
        }

        if (dto.getHealthCheckDetailSecondDto() != null) {
            this.healthCheckDetailSecondDto = dto.getHealthCheckDetailSecondDto();
        }
    }
}

package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthCheckDetailDto {
    private HealthCheckDetailFirstDto healthCheckDetailFirstDto;
    private HealthCheckDetailSecondDto healthCheckDetailSecondDto;

    public void mergeInfo(HealthCheckDetailFirstDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setUserId(empDto.getUserId());
        dto.setDeptNm(empDto.getDeptNm());
    }
}

package com.airpremia.eosh.personaldetail.health.service;

import org.springframework.stereotype.Service;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.health.controller.HealthCheckDetailResponse;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailFirstDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthCheckDetailSecondDto;
import com.airpremia.eosh.personaldetail.health.repository.HealthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HealthCheckDetailService {
    private final CommonFunction commonFunction;
    private final HealthRepository healthRepository;

    public HealthCheckDetailResponse selectHealthCheckDetail(
        String empNo, String standardYyyy) {
        HealthCheckDetailFirstDto healthCheckDetailFirstDto = new HealthCheckDetailFirstDto();
        healthCheckDetailFirstDto.setEmpNm(empNo);

        HrEmpDto hrData = commonFunction.getHrEmpNoDto(empNo);

        String userTokenBirthYmd = String.valueOf(hrData.getBirthYmd());
        String userId = empNo.substring(1, 7) + userTokenBirthYmd.replace("-", "");

        HealthCheckDetailFirstDto userhealthCheckDetailFirstDto =
            healthRepository.selectHealthCheckFirstDetailPage(userId, standardYyyy);

        HealthCheckDetailSecondDto userhealthCheckDetailSecondDto =
            healthRepository.selectHealthCheckSecondDetailPage(userId, standardYyyy);

        HealthCheckDetailDto healthCheckDetailDto = new HealthCheckDetailDto();
        healthCheckDetailDto.setHealthCheckDetailFirstDto(userhealthCheckDetailFirstDto);
        healthCheckDetailDto.setHealthCheckDetailSecondDto(userhealthCheckDetailSecondDto);
        return new HealthCheckDetailResponse(healthCheckDetailDto, hrData);
    }
}

package com.airpremia.eosh.personaldetail.health.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.personaldetail.health.service.HealthCheckDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/health-check-detail")
@Tag(name = "건강검진 정보")
@Slf4j
@AllArgsConstructor
public class HealthCheckDetailController {
    private final HealthCheckDetailService healthCheckDetailService;

    @Operation(summary = "건강검진 상세")
    @GetMapping(value = "/{empNo}/{standardYyyy}")
    public ResponseEntity<HealthCheckDetailResponse> selectHealthCheckDetail(
        @PathVariable("empNo") String empNo, @PathVariable("standardYyyy") String standardYyyy) {
        HealthCheckDetailResponse
            res = healthCheckDetailService.selectHealthCheckDetail(empNo, standardYyyy);
        return ResponseEntity.ok(res);
    }

}

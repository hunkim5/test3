package com.airpremia.eosh.health.healthdailylog.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.health.healthdailylog.service.HealthDailyLogService;
import com.airpremia.esmsfos.core.annotation.OpenApiFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/health/health-daily-log")
@Tag(name = "보건일지")
@Slf4j
@AllArgsConstructor
public class HealthDailyLogController {
    private final HealthDailyLogService healthDailyLogService;

    @Operation(summary = "보건일지 상세")
    @GetMapping(value = "/{healthDailyLogSeq}")
    public ResponseEntity<HealthDailyLogResponse> selectHealthDailyLog(
        @PathVariable long healthDailyLogSeq) {
        HealthDailyLogResponse
            res =
            healthDailyLogService.selectHealthDailyLog(healthDailyLogSeq);
        return ResponseEntity.ok(res);
    }


    @Operation(summary = "보건일지 수정")
    @PutMapping(value = "/{healthDailyLogSeq}")
    public ResponseEntity<Integer> updateHealthDailyLog(
        @PathVariable long healthDailyLogSeq, @RequestBody HealthDailyLogRequest req) {
        req.setHealthDailyLogSeq(healthDailyLogSeq);
        int res = healthDailyLogService.updateHealthDailyLog(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "보건일지 저장")
    @PostMapping()
    public ResponseEntity<Integer> insertHealthDailyLog(
        @RequestBody
        HealthDailyLogRequest req) {
        int res = healthDailyLogService.insertHealthDailyLog(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "보건일지 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<HealthDailyLogResponse>> selectHealthDailyLogPage(
        @ParameterObject HealthDailyLogRequest searchRequest, Pageable pageable) {
        Page<HealthDailyLogResponse> page =
            healthDailyLogService.selectHealthDailyLogPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "보건일지 삭제")
    @DeleteMapping(value = "/{healthDailyLogSeq}")
    public ResponseEntity<Integer> deleteHealthDailyLog(
        @PathVariable long healthDailyLogSeq) {
        Integer res =
            healthDailyLogService.deleteHealthDailyLog(healthDailyLogSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "healthDaily excel download list")
    @GetMapping(value = "/excel")
    @OpenApiFilter()
    public ResponseEntity<List<HealthDailyLogResponse>> selectHealthDailyExcelList(
        @ParameterObject HealthDailyLogRequest searchRequest) {
        List<HealthDailyLogResponse> result = healthDailyLogService.selectHealthDailyExcelList(searchRequest);
        return ResponseEntity.ok(result);
    }
}

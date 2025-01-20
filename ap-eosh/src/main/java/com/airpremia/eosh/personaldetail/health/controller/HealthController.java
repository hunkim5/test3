package com.airpremia.eosh.personaldetail.health.controller;

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

import com.airpremia.eosh.personaldetail.health.response.HealthDeleteResponse;
import com.airpremia.eosh.personaldetail.health.service.HealthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/health-info")
@Tag(name = "기본정보")
@Slf4j
@AllArgsConstructor
public class HealthController {
    private final HealthService healthService;

    @Operation(summary = "보건 상세")
    @GetMapping(value = "/{userSeq}/{standardYyyy}")
    public ResponseEntity<HealthResponse> selectHealth(
        @PathVariable Long userSeq, @PathVariable String standardYyyy) {
        HealthResponse res = healthService.selectHealth(userSeq, standardYyyy);
        return ResponseEntity.ok(res);
    }


    @Operation(summary = "보건 수정")
    @PutMapping(value = "/{userSeq}/{standardYyyy}")
    public ResponseEntity<Integer> saveHealth(
        @PathVariable Long userSeq, @PathVariable String standardYyyy, @RequestBody HealthRequest req) {
        req.setUserSeq(userSeq);
        req.setStandardYyyy(standardYyyy);
        int res = healthService.saveHealth(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "보건 삭제")
    @DeleteMapping(value = "/{userSeq}/{standardYyyy}")
    public ResponseEntity<HealthDeleteResponse> saveHealth(
        @PathVariable Long userSeq, @PathVariable String standardYyyy) {
        HealthDeleteResponse result = healthService.deleteHealth(userSeq, standardYyyy);
        return ResponseEntity.ok(result);
    }


    @Operation(summary = "보건 상세 userSeq 검색")
    @GetMapping(value = "/{responseKey}")
    public ResponseEntity<HealthResponse> selectUserSeq(
        @PathVariable String responseKey) {
        HealthResponse res = healthService.getUserSeq(responseKey);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "보건 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<HealthPageResponse>> selectMeetingPage(
        @ParameterObject HealthSearchRequest searchRequest, Pageable pageable) {
        Page<HealthPageResponse> page = healthService.selectHealthPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "스트레스 검색 페이지(사용자)")
    @GetMapping(value = "/work-stress/pageable")
    public ResponseEntity<Page<UserWorkStressSurveyPageResponse>> selectUserWorkStressSurveyPage(
        @ParameterObject UserWorkStressSurveySearchRequest searchRequest, Pageable pageable) {
        Page<UserWorkStressSurveyPageResponse> page =
            healthService.selectUserWorkStressSurveyPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "스트레스 상세")
    @GetMapping(value = "/work-stress/{standardYyyy}")
    public ResponseEntity<List<UserWorkStressSurveyResponse>> selectUserWorkStressSurvey(
        @PathVariable String standardYyyy) {
        return ResponseEntity.ok(healthService.selectUserWorkStressSurvey(standardYyyy));
    }

    @Operation(summary = "설문지 작성")
    @PostMapping(value = "/work-stress")
    public ResponseEntity<Integer> saveUserWorkStressSurvey(
        @RequestBody UserWorkStressSurveyInsertUpdateRequest request) {
        int result = healthService.saveUserWorkStressSurvey(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "스트레스 설문 결과(관리자)")
    @GetMapping(value = "/work-stress/result")
    public ResponseEntity<List<WorkStressSurveyReportResponse>> selectUserStressSurveyResult(
        @ParameterObject UserWorkStressSurveySearchRequest req) {
        List<WorkStressSurveyReportResponse> result =
            healthService.selectUserStressSurveyResult(req);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "스트레스 설문 상태 확인")
    @GetMapping("/check/{standardYyyy}")
    public ResponseEntity<Boolean> checkSurveyStatus(@PathVariable String standardYyyy) {
        Boolean result = healthService.checkSurveyStatus(standardYyyy);
        return ResponseEntity.ok(result);
    }
}

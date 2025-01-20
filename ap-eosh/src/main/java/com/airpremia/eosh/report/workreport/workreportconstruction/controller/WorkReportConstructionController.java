package com.airpremia.eosh.report.workreport.workreportconstruction.controller;

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

import com.airpremia.eosh.report.workreport.workreportconstruction.service.WorkReportConstructionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/work-report-construction")
@Tag(name = "건물 설치 이전")
@Slf4j
@AllArgsConstructor
public class WorkReportConstructionController {
    private final WorkReportConstructionService workReportConstructionService;

    @Operation(summary = "건물 설치 이전 저장")
    @PostMapping
    public ResponseEntity<Integer> insertWorkReportConstruction(
        @RequestBody WorkReportConstructionRequest insertRequest) {
        return ResponseEntity.ok(workReportConstructionService.insertWorkReportConstruction(insertRequest));
    }

    @Operation(summary = "건물 설치 이전 수정")
    @PutMapping(value = "/{workReportConstructionSeq}")
    public ResponseEntity<Integer> updateWorkReportConstruction(
        @PathVariable Long workReportConstructionSeq, @RequestBody WorkReportConstructionRequest request) {
        request.setWorkReportConstructionSeq(workReportConstructionSeq);
        return ResponseEntity.ok(workReportConstructionService.updateWorkReportConstruction(request));
    }

    @Operation(summary = "건물 설치 이전 승인,반려")
    @PutMapping(value = "/status/{workReportConstructionSeq}")
    public ResponseEntity<Integer> updateWorkReportConstructionStatus(
        @PathVariable Long workReportConstructionSeq, @RequestBody WorkReportConstructionRequest request) {
        request.setWorkReportConstructionSeq(workReportConstructionSeq);
        return ResponseEntity.ok(workReportConstructionService.updateWorkReportConstructionStatus(request));
    }

    @Operation(summary = "건물 설치 이전 상세")
    @GetMapping(value = "/{workReportConstructionSeq}")
    public ResponseEntity<WorkReportConstructionResponse> selectWorkReportConstruction(
        @PathVariable Long workReportConstructionSeq) {
        WorkReportConstructionResponse res =
            workReportConstructionService.selectWorkReportConstruction(workReportConstructionSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "건물 설치 이전 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<WorkReportConstructionPageResponse>> selectWorkReportConstructionPage(
        @ParameterObject WorkReportConstructionSearchRequest searchRequest, Pageable pageable) {
        Page<WorkReportConstructionPageResponse> page =
            workReportConstructionService.selectWorkReportConstructionPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "건물 설치 이전 삭제")
    @DeleteMapping(value = "/{workReportConstructionSeq}")
    public ResponseEntity<Integer> deleteWorkReportConstruction(
        @PathVariable Long workReportConstructionSeq) {
        return ResponseEntity.ok(workReportConstructionService.deleteWorkReportConstruction(workReportConstructionSeq));
    }
}

package com.airpremia.eosh.report.report.controller;


import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.report.report.request.issue.ReportIssueRequest;
import com.airpremia.eosh.report.report.request.report.ReportCollectionRequest;
import com.airpremia.eosh.report.report.request.report.ReportRequest;
import com.airpremia.eosh.report.report.request.transfer.ReportSystemTransferRequest;
import com.airpremia.eosh.report.report.response.report.ReportCollectionResponse;
import com.airpremia.eosh.report.report.response.report.ReportResponse;
import com.airpremia.eosh.report.report.service.ReportService;
import com.airpremia.esmsfos.core.annotation.OpenApiFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/report")
@Tag(name = "Report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @Operation(summary = "리포트 페이지 조회")
    @GetMapping(value = "/pageable")
    public ResponseEntity<Page<ReportCollectionResponse>> selectReportPage(
        @ParameterObject ReportCollectionRequest request
    ) {
        Page<ReportCollectionResponse> result = reportService.selectReportPage(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "연관 리포트 조회")
    @GetMapping(value = "/related")
    public ResponseEntity<List<ReportCollectionResponse>> selectRelatedReport(
        @RequestParam List<String> reportUuidList
    ) {
        List<ReportCollectionResponse> result = reportService.selectRelatedReport(reportUuidList);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "ADMIN 리포트 페이지 조회")
    @GetMapping(value = "/admin/pageable")
    public ResponseEntity<Page<ReportCollectionResponse>> selectAdminReportPage(
        @ParameterObject ReportCollectionRequest request
    ) {
        Page<ReportCollectionResponse> result = reportService.selectAdminReportPage(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "ADMIN 리포트 List 조회")
    @GetMapping("/admin")
    public ResponseEntity<List<ReportCollectionResponse>> selectAdminReportList(
        @ParameterObject ReportCollectionRequest request
    ) {
        List<ReportCollectionResponse> result = reportService.selectAdminReportList(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "리포트 상세조회")
    @GetMapping("/{reportUuid}")
    public ResponseEntity<ReportResponse> selectReportDetail(
        @PathVariable String reportUuid
    ) {
        ReportResponse result = reportService.selectReportDetail(reportUuid);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "report 삭제")
    @DeleteMapping
    public ResponseEntity<Integer> deleteReportList(
        @OpenApiFilter()
        @RequestBody List<ReportRequest> reportList
    ) {
        Integer result = reportService.deleteReportList(reportList);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "report issue 등록")
    @PostMapping(value = "/issue")
    public ResponseEntity<List<Long>> insertIssueList(
        @RequestBody List<ReportIssueRequest> reportIssueRequestList
    ) {
        List<Long> issueSeqList = reportService.insertIssueList(reportIssueRequestList);

        return ResponseEntity.ok(issueSeqList);
    }

    @Operation(summary = "보고서 목록 이관")
    @PutMapping(value = "/transfer")
    public ResponseEntity<List<ReportCollectionResponse>> updateReportSystemTransfer(
        @RequestBody List<ReportSystemTransferRequest> request
    ) {
        List<ReportCollectionResponse> resultList = reportService.updateReportSystemTransfer(request);
        return ResponseEntity.ok(resultList);
    }

    @Operation(summary = "보고서 목록 공유")
    @PostMapping(value = "/share")
    public ResponseEntity<List<ReportCollectionResponse>> sharedReportList(
        @OpenApiFilter()
        @RequestBody List<ReportSystemTransferRequest> request
    ) {
        List<ReportCollectionResponse> result = reportService.sharedReportList(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "보고서 목록 산재여부 변경")
    @PatchMapping("/industrial-accident")
    @OpenApiFilter()
    public ResponseEntity<List<ReportCollectionResponse>> updateReportIndustrialAccident(
        @RequestBody List<ReportRequest> request
    ) {
        List<ReportCollectionResponse> result = reportService.updateReportIndustrialAccident(request);
        return ResponseEntity.ok(result);
    }
}

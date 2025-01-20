package com.airpremia.eosh.report.workreport.reportcontract.controller;

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

import com.airpremia.eosh.report.workreport.reportcontract.service.ReportContractService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/work-report-contract")
@Tag(name = "협력업체")
@Slf4j
@AllArgsConstructor
public class ReportContractController {
    private final ReportContractService reportContractService;

    @Operation(summary = "협력업체 저장")
    @PostMapping
    public ResponseEntity<Integer> insertReportContract(
        @RequestBody
        ReportContractRequest insertRequest) {
        return ResponseEntity.ok(
            reportContractService.insertReportContract(insertRequest));
    }

    @Operation(summary = "협력업체 수정")
    @PutMapping(value = "/{reportContractSeq}")
    public ResponseEntity<Integer> updateReportContract(
        @PathVariable Long reportContractSeq,
        @RequestBody
        ReportContractRequest request) {
        request.setContractSeq(reportContractSeq);
        return ResponseEntity.ok(reportContractService.updateReportContract(request));
    }

    @Operation(summary = "협력업체 승인,반려")
    @PutMapping(value = "/status/{reportContractSeq}")
    public ResponseEntity<Integer> updateReportContractStatus(
        @PathVariable Long reportContractSeq,
        @RequestBody ReportContractRequest request) {
        request.setContractSeq(reportContractSeq);
        return ResponseEntity.ok(
            reportContractService.updateReportContractStatus(request));
    }

    @Operation(summary = "협력업체 상세")
    @GetMapping(value = "/{reportContractSeq}")
    public ResponseEntity<ReportContractResponse> selectReportContract(
        @PathVariable Long reportContractSeq) {
        ReportContractResponse res =
            reportContractService.selectReportContract(
                reportContractSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "협력업체 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<ReportContractPageResponse>> selectReportContractPage(
        @ParameterObject ReportContractSearchRequest searchRequest, Pageable pageable) {
        Page<ReportContractPageResponse> page =
            reportContractService.selectReportContractPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "협력업체 삭제")
    @DeleteMapping(value = "/{reportContractSeq}")
    public ResponseEntity<Integer> deleteReportContract(
        @PathVariable Long reportContractSeq) {
        return ResponseEntity.ok(
            reportContractService.deleteReportContract(
                reportContractSeq));
    }
}

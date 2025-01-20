package com.airpremia.eosh.report.workreport.facility.controller;

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

import com.airpremia.eosh.report.workreport.facility.service.WorkReportFacilityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/work-report-facility")
@Tag(name = "기계구,설비,원재료")
@Slf4j
@AllArgsConstructor
public class WorkReportFacilityController {
    private final WorkReportFacilityService workReportFacilityServiceService;

    @Operation(summary = "기계구,설비,원재료 저장")
    @PostMapping
    public ResponseEntity<Integer> insertWorkReportFacility(
        @RequestBody WorkReportFacilityRequest insertRequest) {
        return ResponseEntity.ok(workReportFacilityServiceService.insertWorkReportFacility(insertRequest));
    }

    @Operation(summary = "기계구,설비,원재료 수정")
    @PutMapping(value = "/{facilitySeq}")
    public ResponseEntity<Integer> updateWorkReportFacility(
        @PathVariable Long facilitySeq, @RequestBody WorkReportFacilityUpdateRequest request) {
        return ResponseEntity.ok(workReportFacilityServiceService.updateWorkReportFacility(request, facilitySeq));
    }

    @Operation(summary = "기계구,설비,원재료 승인,반려")
    @PutMapping(value = "/status/{facilitySeq}")
    public ResponseEntity<Integer> updateWorkReportFacilityStatus(
        @PathVariable Long facilitySeq, @RequestBody WorkReportFacilityRequest request) {
        return ResponseEntity.ok(workReportFacilityServiceService.updateWorkReportFacilityStatus(request, facilitySeq));
    }

    @Operation(summary = "기계구,설비,원재료 상세")
    @GetMapping(value = "/{facilitySeq}")
    public ResponseEntity<WorkReportFacilityResponse> selectWorkReportFacility(
        @PathVariable Long facilitySeq) {
        WorkReportFacilityResponse res =
            workReportFacilityServiceService.selectWorkReportFacility(facilitySeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "기계구,설비,원재료 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<WorkReportFacilityPageResponse>> selectWorkReportFacilityPage(
        @ParameterObject WorkReportFacilitySearchRequest searchRequest, Pageable pageable) {
        Page<WorkReportFacilityPageResponse> pages =
            workReportFacilityServiceService.selectWorkReportFacilityPage(searchRequest, pageable);
        return ResponseEntity.ok(pages);
    }

    @Operation(summary = "기계구,설비,원재료 삭제")
    @DeleteMapping(value = "/{facilitySeq}")
    public ResponseEntity<Integer> deleteWorkReportFacility(
        @PathVariable Long facilitySeq) {
        return ResponseEntity.ok(workReportFacilityServiceService.deleteWorkReportFacility(facilitySeq));
    }

    @Operation(summary = "기계구,설비 수량 수정")
    @PutMapping(value = "/updatequantity/{facilitySeq}")
    public ResponseEntity<Integer> updateQuantity(
        @PathVariable Long facilitySeq, @RequestBody WorkReportFacilityUpdateQuantityRequest request) {
        request.setFacilitySeq(facilitySeq);
        return ResponseEntity.ok(workReportFacilityServiceService.updateQuantity(request));
    }
}

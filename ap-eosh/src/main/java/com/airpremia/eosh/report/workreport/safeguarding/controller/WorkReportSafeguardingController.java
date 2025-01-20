package com.airpremia.eosh.report.workreport.safeguarding.controller;

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

import com.airpremia.eosh.report.workreport.safeguarding.service.WorkReportSafeguardingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/work-report/safeguarding")
@Tag(name = "방호구,방호장치")
@Slf4j
@AllArgsConstructor
public class WorkReportSafeguardingController {
    private final WorkReportSafeguardingService workReportSafeguardingService;

    @Operation(summary = "방호구,방호장치 저장")
    @PostMapping
    public ResponseEntity<Integer> insertWorkReportSafeguarding(
        @RequestBody WorkReportSafeguardingRequest insertRequest) {
        return ResponseEntity.ok(workReportSafeguardingService.insertWorkReportSafeguarding(insertRequest));
    }

    @Operation(summary = "방호구,방호장치 수정")
    @PutMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<Integer> updateWorkReportSafeguarding(
        @PathVariable Long safeguardingSeq, @RequestBody WorkReportSafeguardingRequest request) {
        request.setSafeguardingSeq(safeguardingSeq);
        return ResponseEntity.ok(workReportSafeguardingService.updateWorkReportSafeguarding(request));
    }

    @Operation(summary = "방호구,방호장치 승인,반려")
    @PutMapping(value = "/status/{safeguardingSeq}")
    public ResponseEntity<Integer> updateWorkReportSafeguardingStatus(
        @PathVariable Long safeguardingSeq, @RequestBody WorkReportSafeguardingRequest request) {
        request.setSafeguardingSeq(safeguardingSeq);
        return ResponseEntity.ok(workReportSafeguardingService.updateWorkReportSafeguardingStatus(request));
    }

    @Operation(summary = "방호구,방호장치 상세")
    @GetMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<WorkReportSafeguardingResponse> selectWorkReportSafeguarding(
        @PathVariable Long safeguardingSeq) {
        WorkReportSafeguardingResponse res =
            workReportSafeguardingService.selectWorkReportSafeguarding(safeguardingSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "방호구,방호장치 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<WorkReportSafeguardingResponse>> selectWorkReportSafeguardingPage(
        @ParameterObject WorkReportSafeguardingSearchRequest searchRequest, Pageable pageable) {
        Page<WorkReportSafeguardingResponse> page =
            workReportSafeguardingService.selectWorkReportSafeguardingPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "방호구,방호장치 삭제")
    @DeleteMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<Integer> deleteWorkReportSafeguarding(
        @PathVariable Long safeguardingSeq) {
        return ResponseEntity.ok(workReportSafeguardingService.deleteWorkReportSafeguarding(safeguardingSeq));
    }

    @Operation(summary = "Personal detail > 방호장치 검색")
    @GetMapping(value = "/user-protection-device")
    public ResponseEntity<Page<UserProtectiondeviceResponse>> selectUserProtectGearStatus(
        @ParameterObject UserProtectiondeviceSearchRequest searchRequest, Pageable pageable) {
        Page<UserProtectiondeviceResponse> page =
            workReportSafeguardingService.selectUserProtectiondevicePage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Personal detail > 보호구 검색")
    @GetMapping(value = "/user-protect-gear")
    public ResponseEntity<Page<UserProtectGearResponse>> selectUserProtectGearPage(
        @ParameterObject UserProtectGearSearchRequest searchRequest, Pageable pageable) {
        Page<UserProtectGearResponse> page =
            workReportSafeguardingService.selectUserProtectGearPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Personal detail > 방호장치 수량 수정")
    @PutMapping(value = "/protection-device/quantity/{userProtectionDeviceStatusSeq}")
    public ResponseEntity<Integer> updateUserProtectionDeviceQuantity(
        @PathVariable Long userProtectionDeviceStatusSeq, @RequestBody UserProtectiondeviceRequest request) {
        request.setUserProtectiondeviceStatusSeq(userProtectionDeviceStatusSeq);
        return ResponseEntity.ok(workReportSafeguardingService.updateUserProtectionDeviceQuantity(request));
    }

    @Operation(summary = "Personal detail > 방어구 수량 수정")
    @PutMapping(value = "/safeguarding-protect-gear/quantity/{userProtectGearStatusSeq}")
    public ResponseEntity<Integer> updateWorkReportSafeguardingProtectGearQuantity(
        @PathVariable Long userProtectGearStatusSeq, @RequestBody UserProtectGearRequest request) {
        request.setUserProtectGearStatusSeq(userProtectGearStatusSeq);
        return ResponseEntity.ok(
            workReportSafeguardingService.updateWorkReportSafeguardingProtectGearQuantity(request));
    }
}

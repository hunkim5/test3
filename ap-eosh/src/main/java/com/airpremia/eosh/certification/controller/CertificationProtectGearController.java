package com.airpremia.eosh.certification.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.certification.service.CertificationProtectGearService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/certification-protect-gear")
@Tag(name = "보호구 인증")
@AllArgsConstructor
public class CertificationProtectGearController {

    private final CertificationProtectGearService certificationProtectGearService;

    @Operation(summary = "보호구 인증 페이지")
    @GetMapping
    public ResponseEntity<Page<CertificationSafeguardingResponse>> selectCertificationProtectGearPage(
        @ParameterObject CertificationSafeguardingSearchRequest searchRequest, Pageable pageable) {
        Page<CertificationSafeguardingResponse> pages = certificationProtectGearService.selectCertificationProtectGearPage(searchRequest, pageable);
        return ResponseEntity.ok(pages);
    }

    @Operation(summary = "보호구 인증 상세")
    @GetMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<CertificationSafeguardingResponse> selectCertificationProtectGear(
        @PathVariable Long safeguardingSeq) {
        CertificationSafeguardingResponse result = certificationProtectGearService.selectCertificationProtectGear(safeguardingSeq);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "보호구 인증 수정")
    @PutMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<Integer> updateCertificationProtectGear(
        @PathVariable Long safeguardingSeq, @RequestBody CertificationSafeguardingRequest request) {
        return ResponseEntity.ok(certificationProtectGearService.updateCertificationProtectGear(request, safeguardingSeq));
    }

    @Operation(summary = "보호구 부서별 수량")
    @GetMapping(value = "/department-quantity/{deptCd}")
    public ResponseEntity<List<ProtectGearDeptResponse>> selectProtectGearDepartmentQuantity(
        @PathVariable String deptCd) {
        List<ProtectGearDeptResponse> result = certificationProtectGearService.selectProtectGearDepartmentQuantity(deptCd);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "보호구 부서별 수량 수정")
    @PutMapping(value = "/department-quantity")
    public ResponseEntity<Integer> updateProtectGearDepartmentQuantity(
        @RequestBody List<ProtectGearDeptUpdateRequest> request) {
        return ResponseEntity.ok(certificationProtectGearService.updateProtectGearDepartmentQuantity(request));
    }

    @Operation(summary = "보호구 부서별 사용자 수량")
    @GetMapping(value = "/department-quantity/user")
    public ResponseEntity<List<UserProtectGearDeptResponse>> selectUserProtectGearDeptStatus(
        @ParameterObject UserProtectGearDeptRequest request) {
        List<UserProtectGearDeptResponse> result = certificationProtectGearService.selectUserProtectGearDeptStatus(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "보호구 부서별 사용자 수량 수정")
    @PutMapping(value = "/department-quantity/user")
    public ResponseEntity<Integer> updateUserProtectGearDeptStatus(
        @RequestBody List<UserProtectGearDeptUpdateRequest> request) {
        return ResponseEntity.ok(certificationProtectGearService.updateUserProtectGearDeptStatus(request));
    }



}

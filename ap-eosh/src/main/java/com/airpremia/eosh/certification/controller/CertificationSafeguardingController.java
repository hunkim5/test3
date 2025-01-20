package com.airpremia.eosh.certification.controller;

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

import com.airpremia.eosh.certification.service.CertificationSafeguardingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/certification-safeguarding")
@Tag(name = "방호장치 인증")
@AllArgsConstructor
public class CertificationSafeguardingController {

    private final CertificationSafeguardingService certificationSafeguardingService;

    @Operation(summary = "방호장치 인증 페이지")
    @GetMapping
    public ResponseEntity<Page<CertificationSafeguardingResponse>> selectCertificationSafeguardingPage(
        @ParameterObject CertificationSafeguardingSearchRequest searchRequest, Pageable pageable) {
        Page<CertificationSafeguardingResponse> pages = certificationSafeguardingService.selectCertificationSafeguardingPage(searchRequest, pageable);
        return ResponseEntity.ok(pages);
    }

    @Operation(summary = "방호장치 인증 상세")
    @GetMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<CertificationSafeguardingResponse> selectCertificationSafeguarding(
        @PathVariable Long safeguardingSeq) {
        CertificationSafeguardingResponse result = certificationSafeguardingService.selectCertificationSafeguarding(safeguardingSeq);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "방호장치 인증 수정")
    @PutMapping(value = "/{safeguardingSeq}")
    public ResponseEntity<Integer> updateCertificationSafeguarding(
        @PathVariable Long safeguardingSeq, @RequestBody CertificationSafeguardingRequest request) {
        return ResponseEntity.ok(certificationSafeguardingService.updateCertificationSafeguarding(request, safeguardingSeq));
    }

}

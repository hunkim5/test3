package com.airpremia.eosh.certification.facility.controller;

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

import com.airpremia.eosh.certification.facility.service.CertificationFacilityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/certification-facility")
@Tag(name = "기계,기구,설비 인증")
@AllArgsConstructor
public class CertificationFacilityController {

    private CertificationFacilityService certificationFacilityService;

    @Operation(summary = "기계,기구,설비 인증 페이지 검색")
    @GetMapping
    public ResponseEntity<Page<CertificationFacilityResponse>> selectCertificationFacilityPage(
        @ParameterObject CertificationFacilityRequest searchRequest, Pageable pageable) {
        Page<CertificationFacilityResponse> pages = certificationFacilityService.selectCertificationFacilityPage(searchRequest, pageable);
        return ResponseEntity.ok(pages);
    }

    @Operation(summary = "기계,기구,설비 인증 상세")
    @GetMapping(value = "/{facilitySeq}")
    public ResponseEntity<CertificationFacilityResponse> selectCertificationFacility(
        @PathVariable Long facilitySeq) {
        CertificationFacilityResponse res = certificationFacilityService.selectCertificationFacility(facilitySeq);
        return ResponseEntity.ok(res);
    }


    @Operation(summary = "기계,기구,설비 인증 수정")
    @PutMapping(value = "/{facilitySeq}")
    public ResponseEntity<Integer> updateCertificationFacility(
        @PathVariable Long facilitySeq, @RequestBody CertificationFacilityRequest request) {
        request.setFacilitySeq(facilitySeq);
        return ResponseEntity.ok(certificationFacilityService.updateCertificationFacility(request));
    }

}

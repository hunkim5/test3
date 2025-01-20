package com.airpremia.eosh.risk.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.risk.request.RiskCodeDetailRequest;
import com.airpremia.eosh.risk.response.RiskCodeDetailResponse;
import com.airpremia.eosh.risk.response.VersionRiskCollectionResponse;
import com.airpremia.eosh.risk.service.RiskManageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/risk/manage/version")
@RequiredArgsConstructor
@Tag(name = "admin risk version 관리")
public class RiskManageVersionController {
    private final RiskManageService riskManageService;

    @Operation(summary = "risk version 목록")
    @GetMapping
    public ResponseEntity<List<VersionRiskCollectionResponse>> selectRiskVersionList() {
        List<VersionRiskCollectionResponse> result = riskManageService.selectRiskVersionList();

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "risk version 상세 조회")
    @GetMapping(value = "{riskVersionSeq}")
    public ResponseEntity<RiskCodeDetailResponse> selectRiskDetail(@PathVariable Long riskVersionSeq) {
        RiskCodeDetailResponse result = riskManageService.selectRiskDetail(riskVersionSeq);

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "risk version 등록")
    @PostMapping
    public ResponseEntity<RiskCodeDetailResponse> insertRiskDetail(@RequestBody RiskCodeDetailRequest request) {
        return ResponseEntity.ok(riskManageService.insertRiskDetail(request));
    }

    @Operation(summary = "risk version 수정")
    @PutMapping(value = "/{riskVersionSeq}")
    public ResponseEntity<RiskCodeDetailResponse> updateRiskDetail(
        @RequestBody RiskCodeDetailRequest request,
        @PathVariable Long riskVersionSeq
    ) {
        return ResponseEntity.ok(riskManageService.updateRiskDetail(riskVersionSeq, request));
    }
}

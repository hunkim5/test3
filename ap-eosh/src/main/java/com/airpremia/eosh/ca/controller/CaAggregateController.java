package com.airpremia.eosh.ca.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.ca.request.ca.CaCollectionRequest;
import com.airpremia.eosh.ca.request.ca.SubscribeCaItemRequest;
import com.airpremia.eosh.ca.response.ca.CaCollectionResponse;
import com.airpremia.eosh.ca.response.ca.SubscribeCaItemResponse;
import com.airpremia.eosh.ca.response.incharge.SubscribeCaItemInchargeResponse;
import com.airpremia.eosh.ca.service.CaService;
import com.airpremia.esmsfos.core.annotation.OpenApiFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/ca/aggregate")
@Tag(name = "CA의 업무의 개인화 혹은 ADMIN 의 전체적인 관점의 업무 진행")
@RequiredArgsConstructor
public class CaAggregateController {
    private final CaService caService;

    @Operation(summary = "ca page 조회")
    @GetMapping(value = "pageable")
    @OpenApiFilter()
    public ResponseEntity<Page<CaCollectionResponse>> selectCaPage(
        @ParameterObject CaCollectionRequest request, Pageable pageable) {
        Page<CaCollectionResponse> result = caService.selectCaPage(request, pageable);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "ca List 조회")
    @GetMapping()
    public ResponseEntity<List<CaCollectionResponse>> selectCaList(
        @ParameterObject CaCollectionRequest request) {
        List<CaCollectionResponse> result = caService.selectCaList(request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "CA 상세 조회")
    @GetMapping(value = "{subscribeCaItemSeq}")
    public ResponseEntity<SubscribeCaItemResponse> selectCaDetail(
        @PathVariable Long subscribeCaItemSeq
    ) {
        return ResponseEntity.ok(caService.selectDetail(subscribeCaItemSeq));
    }

    @Operation(summary = "승인 상태 변경")
    @PatchMapping(value = "/appvalprc/{subscribeCaItemSeq}")
    public ResponseEntity<SubscribeCaItemResponse> updateCaItemAppvalprc(
        @OpenApiFilter(whiteList = {"subscribeCaItemSeq", "caAppvalprcEnum", "feedbackContent"})
        @RequestBody SubscribeCaItemRequest request,
        @PathVariable Long subscribeCaItemSeq
    ) {
        SubscribeCaItemResponse result = caService.updateCaItemAppvalprc(subscribeCaItemSeq, request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "ca 담당자 목록 변경")
    @PutMapping(value = "/incharges/{subscribeCaItemSeq}")
    public ResponseEntity<List<SubscribeCaItemInchargeResponse>> updateCaItemInchargeList(
        @OpenApiFilter(whiteList = {"subscribeCaUuid", "inchargeList"})
        @RequestBody SubscribeCaItemRequest request,
        @PathVariable Long subscribeCaItemSeq
    ) {
        List<SubscribeCaItemInchargeResponse> result = caService.updateCaItemInchargeList(subscribeCaItemSeq, request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "CA 수정")
    @PutMapping(value = "{subscribeCaItemSeq}")
    public ResponseEntity<SubscribeCaItemResponse> updateCaItem(
        @PathVariable Long subscribeCaItemSeq,
        @RequestBody SubscribeCaItemRequest request
    ) {
        SubscribeCaItemResponse result = caService.updateCaItem(subscribeCaItemSeq, request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "cap 수정")
    @PutMapping(value = "cap/{subscribeCaItemSeq}")
    public ResponseEntity<SubscribeCaItemResponse> updateCaItemCap(
        @PathVariable Long subscribeCaItemSeq,
        @RequestBody SubscribeCaItemRequest request) {
        SubscribeCaItemResponse result = caService.updateCaItemCap(subscribeCaItemSeq, request);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "cai 수정")
    @PutMapping(value = "cai/{subscribeCaItemSeq}")
    public ResponseEntity<SubscribeCaItemResponse> updateCaItemCai(
        @PathVariable Long subscribeCaItemSeq,
        @RequestBody SubscribeCaItemRequest request) {
        SubscribeCaItemResponse result = caService.updateCaItemCai(subscribeCaItemSeq, request);
        return ResponseEntity.ok(result);
    }
}

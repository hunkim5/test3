package com.airpremia.eosh.msds.controller;

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

import com.airpremia.eosh.msds.service.MsdsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/msds")
@Tag(name = "MSDS")
@Slf4j
@AllArgsConstructor
public class MsdsController {
    private final MsdsService msdsService;

    @Operation(summary = "MSDS 저장")
    @PostMapping
    public ResponseEntity<Integer> insertMsds(
        @RequestBody
        MsdsRequest insertRequest) {
        return ResponseEntity.ok(
            msdsService.insertMsds(insertRequest));
    }

    @Operation(summary = "MSDS 수정")
    @PutMapping(value = "/{msdsSeq}")
    public ResponseEntity<Integer> updateMsds(
        @PathVariable Long msdsSeq,
        @RequestBody
        MsdsRequest request) {
        request.setMsdsSeq(msdsSeq);
        return ResponseEntity.ok(msdsService.updateMsds(request));
    }

    @Operation(summary = "MSDS 상세")
    @GetMapping(value = "/{msdsSeq}")
    public ResponseEntity<MsdsResponse> selectMsds(
        @PathVariable Long msdsSeq) {
        MsdsResponse res =
            msdsService.selectMsds(
                msdsSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "MSDS 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<MsdsResponse>> selectMsdsPage(
        @ParameterObject MsdsSearchRequest searchRequest, Pageable pageable) {
        Page<MsdsResponse> page =
            msdsService.selectMsdsPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "MSDS 삭제")
    @DeleteMapping(value = "/{msdsSeq}")
    public ResponseEntity<Integer> deleteMsds(
        @PathVariable Long msdsSeq) {
        return ResponseEntity.ok(
            msdsService.deleteMsds(msdsSeq));
    }
}

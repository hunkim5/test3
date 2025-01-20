package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller;

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

import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.service.WorkReportEquipmentDisassemblyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/work-report-equipment-disassembly")
@Tag(name = "방호조치 해체")
@Slf4j
@AllArgsConstructor
public class WorkReportEquipmentDisassemblyController {
    private final WorkReportEquipmentDisassemblyService workReportEquipmentDisassemblyService;

    @Operation(summary = "방호조치 해체 저장")
    @PostMapping
    public ResponseEntity<Integer> insertWorkReportEquipmentDisassembly(
        @RequestBody WorkReportEquipmentDisassemblyRequest insertRequest) {
        return ResponseEntity.ok(
            workReportEquipmentDisassemblyService.insertWorkReportEquipmentDisassembly(insertRequest));
    }

    @Operation(summary = "방호조치 해체 수정")
    @PutMapping(value = "/{workReportEquipmentDisassemblySeq}")
    public ResponseEntity<Integer> updateWorkReportEquipmentDisassembly(
        @PathVariable Long workReportEquipmentDisassemblySeq,
        @RequestBody WorkReportEquipmentDisassemblyRequest request) {
        request.setWorkReportEquipmentDisassemblySeq(workReportEquipmentDisassemblySeq);
        return ResponseEntity.ok(workReportEquipmentDisassemblyService.updateWorkReportEquipmentDisassembly(request));
    }

    @Operation(summary = "방호조치 해체 승인,반려")
    @PutMapping(value = "/status/{workReportEquipmentDisassemblySeq}")
    public ResponseEntity<Integer> updateWorkReportEquipmentDisassemblyStatus(
        @PathVariable Long workReportEquipmentDisassemblySeq,
        @RequestBody WorkReportEquipmentDisassemblyRequest request) {
        request.setWorkReportEquipmentDisassemblySeq(workReportEquipmentDisassemblySeq);
        return ResponseEntity.ok(
            workReportEquipmentDisassemblyService.updateWorkReportEquipmentDisassemblyStatus(request));
    }

    @Operation(summary = "방호조치 해체 상세")
    @GetMapping(value = "/{workReportEquipmentDisassemblySeq}")
    public ResponseEntity<WorkReportEquipmentDisassemblyResponse> selectWorkReportEquipmentDisassembly(
        @PathVariable Long workReportEquipmentDisassemblySeq) {
        WorkReportEquipmentDisassemblyResponse res =
            workReportEquipmentDisassemblyService.selectWorkReportEquipmentDisassembly(
                workReportEquipmentDisassemblySeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "방호조치 해체 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<WorkReportEquipmentDisassemblyPageResponse>> selectWorkReportEquipmentDisassemblyPage(
        @ParameterObject WorkReportEquipmentDisassemblySearchRequest searchRequest, Pageable pageable) {
        Page<WorkReportEquipmentDisassemblyPageResponse> page =
            workReportEquipmentDisassemblyService.selectWorkReportEquipmentDisassemblyPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "방호조치 해체 삭제")
    @DeleteMapping(value = "/{workReportEquipmentDisassemblySeq}")
    public ResponseEntity<Integer> deleteWorkReportEquipmentDisassembly(
        @PathVariable Long workReportEquipmentDisassemblySeq) {
        return ResponseEntity.ok(
            workReportEquipmentDisassemblyService.deleteWorkReportEquipmentDisassembly(
                workReportEquipmentDisassemblySeq));
    }
}

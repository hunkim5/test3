package com.airpremia.eosh.checklist.controller;

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

import com.airpremia.eosh.checklist.request.ChecklistRequest;
import com.airpremia.eosh.checklist.request.ChecklistSearchRequest;
import com.airpremia.eosh.checklist.response.ChecklistResponse;
import com.airpremia.eosh.checklist.service.ChecklistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/checklist")
@Tag(name = "점검표")
@Slf4j
@RequiredArgsConstructor
public class ChecklistController {
    private final ChecklistService checklistService;

    @Operation(summary = "점검표 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<ChecklistResponse>> selectChecklistPage(
        @ParameterObject ChecklistSearchRequest searchRequest, Pageable pageable) {
        Page<ChecklistResponse> page = checklistService.selectChecklistPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "점검표 상세")
    @GetMapping(value = "/{checklistSeq}")
    public ResponseEntity<ChecklistResponse> selectChecklistDetail(@PathVariable Long checklistSeq) {
        ChecklistResponse res = checklistService.selectChecklistDetail(checklistSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "점검표 저장")
    @PostMapping
    public ResponseEntity<Long> insertChecklist(
        @RequestBody ChecklistRequest request) {
        return ResponseEntity.ok(checklistService.insertChecklist(request));
    }

    @Operation(summary = "점검표 수정")
    @PutMapping
    public ResponseEntity<Integer> updateChecklist(
        @RequestBody ChecklistRequest request) {
        return ResponseEntity.ok(checklistService.updateChecklist(request));
    }

    @Operation(summary = "점검표 삭제")
    @DeleteMapping
    public ResponseEntity<Integer> deleteChecklist(
        @RequestBody List<ChecklistRequest> deleteList) {
        return ResponseEntity.ok(checklistService.deleteChecklist(deleteList));
    }
}

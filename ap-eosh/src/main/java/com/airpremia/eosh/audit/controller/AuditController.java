package com.airpremia.eosh.audit.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.audit.service.AuditService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/audit")
@Tag(name = "심사")
@Slf4j
@RequiredArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @Operation(summary = "심사 점검표 저장 업데이트")
    @PutMapping(value = "")
    public ResponseEntity<Integer> insertOrUpdateAudit(
        @RequestBody AuditChecklistRequest insertRequest) {
        return ResponseEntity.ok(auditService.insertOrUpdateAudit(insertRequest));
    }

    @Operation(summary = "심사 상세")
    @GetMapping(value = "/{auditSeq}/{inspectorName}")
    public ResponseEntity<AuditChecklistResponse> selectChecklist(
        @PathVariable Long auditSeq, @PathVariable String inspectorName) {
        AuditChecklistResponse res = auditService.selectUserCheck(auditSeq, inspectorName);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "심사 Seq 검색")
    @GetMapping(value = "/seq")
    public ResponseEntity<AuditResponse> getAuditDetail(@ParameterObject AuditRequest req) {
        AuditResponse res = auditService.selectAuditDetail(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "심사 페이지 검색")
    @GetMapping()
    public ResponseEntity<List<AuditSearchResponse>> selectMeetingPage(@ParameterObject AuditSearchRequest data) {
        List<AuditSearchResponse> res = auditService.selectAuditPage(data);
        return ResponseEntity.ok(res);
    }
}

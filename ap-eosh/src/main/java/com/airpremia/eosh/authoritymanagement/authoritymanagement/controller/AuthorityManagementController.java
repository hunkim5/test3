package com.airpremia.eosh.authoritymanagement.authoritymanagement.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.service.AuthorityManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/authority/management")
@Tag(name = "권한관리")
@Slf4j
@RequiredArgsConstructor
public class AuthorityManagementController {
    private final AuthorityManagementService authorityManagementService;

    @Operation(summary = "권한관리 Hr 가져오기")
    @PostMapping
    public ResponseEntity<Integer> insertHr() {

        return ResponseEntity.ok(authorityManagementService.insertHr());
    }

    @Operation(summary = "권한 수정")
    @PostMapping(value = "/users")
    public ResponseEntity<Integer> updateAuthorityManagement(
        @RequestBody List<AuthorityManagementUpdateRequest> updateRequestsList) {
        return ResponseEntity.ok(authorityManagementService.updateAuthorityManagement(updateRequestsList));
    }

    @Operation(summary = "권한 상세")
    @GetMapping(value = "/users/{userSeq}")
    public ResponseEntity<AuthorityManagementDetailResponse> selectAuthorityManagement(
        @PathVariable Long userSeq) {
        return ResponseEntity.ok(authorityManagementService.selectAuthorityManagement(userSeq));
    }

    @Operation(summary = "권한관리 페이지 검색")
    @GetMapping(value = "/users")
    public ResponseEntity<Page<AuthorityManagementResponse>> selectChangeManagePage(
        @ParameterObject AuthorityManagementSearchRequest searchRequest, Pageable pageable) {
        Page<AuthorityManagementResponse> page =
            authorityManagementService.selectAuthorityManagementPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }
}

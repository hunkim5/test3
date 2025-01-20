package com.airpremia.eosh.authoritymanagement.authorityrequest.controller;

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

import com.airpremia.eosh.authoritymanagement.authorityrequest.service.AuthorityRequestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/authority/request")
@Tag(name = "권한 요청")
@Slf4j
@AllArgsConstructor
public class AuthorityRequestController {
    private final AuthorityRequestService authorityRequestService;

    @Operation(summary = "권한 요청 저장")
    @PostMapping
    public ResponseEntity<AuthorityRequestInsertResponse> insertAuthorityRequest(
        @RequestBody AuthorityRequestInsertRequest insertRequest) {
        AuthorityRequestInsertResponse res = authorityRequestService.insertinsertAuthorityRequest(insertRequest);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "권한 수정")
    @PutMapping(value = "/{userAuthorityRequestSeq}")
    public ResponseEntity<AuthorityRequestUpdateResponse> updateAuthorityRequest(
        @PathVariable Long userAuthorityRequestSeq, @RequestBody AuthorityRequestUpdateRequest request) {
        request.setUserAuthorityRequestSeq(userAuthorityRequestSeq);
        return ResponseEntity.ok(authorityRequestService.updateAuthorityRequest(request));
    }

    @Operation(summary = "권한 상세")
    @GetMapping(value = "/{userAuthorityRequestSeq}")
    public ResponseEntity<AuthorityRequestResponse> selectAuthorityRequest(@PathVariable Long userAuthorityRequestSeq) {
        AuthorityRequestResponse res = authorityRequestService.selectAuthorityRequest(userAuthorityRequestSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "권한요청 사용자,Admin 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<AuthorityRequestResponse>> selectAuthorityRequestPage(
        @ParameterObject AuthorityRequestSearchRequest searchRequest, Pageable pageable) {
        Page<AuthorityRequestResponse> page =
            authorityRequestService.selectAuthorityRequestPage(searchRequest, pageable);

        return ResponseEntity.ok(page);
    }

    @Operation(summary = "권한요청 삭제")
    @DeleteMapping("/{userAuthorityRequestSeq}")
    public ResponseEntity<Integer> deleteAuthorityRequest(
        @PathVariable long userAuthorityRequestSeq) {
        return ResponseEntity.ok(authorityRequestService.deleteAuthorityRequest(userAuthorityRequestSeq));
    }
}

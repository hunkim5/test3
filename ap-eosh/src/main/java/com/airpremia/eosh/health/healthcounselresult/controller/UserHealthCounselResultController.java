package com.airpremia.eosh.health.healthcounselresult.controller;

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

import com.airpremia.eosh.health.healthcounselresult.service.UserHealthCounselResultService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/health/user-health-counsel-result")
@Tag(name = "사용자 보건 상담 결과")
@Slf4j
@AllArgsConstructor
public class UserHealthCounselResultController {
    private final UserHealthCounselResultService userHealthCounselResultService;

    @Operation(summary = "사용자 보건 상담 결과 저장")
    @PostMapping
    public ResponseEntity<Integer> insertUserHealthCounselResult(
        @RequestBody
        UserHealthCounselResultRequest insertRequest) {
        return ResponseEntity.ok(
            userHealthCounselResultService.insertUserHealthCounselResult(insertRequest));
    }

    @Operation(summary = "사용자 보건 상담 결과 수정")
    @PutMapping(value = "/{userHealthCounselResultSeq}")
    public ResponseEntity<Integer> updateUserHealthCounselResult(
        @PathVariable Long userHealthCounselResultSeq,
        @RequestBody
        UserHealthCounselResultRequest request) {
        request.setUserHealthCounselResultSeq(userHealthCounselResultSeq);
        return ResponseEntity.ok(userHealthCounselResultService.updateUserHealthCounselResult(request));
    }

    @Operation(summary = "사용자 보건 상담 결과 상세")
    @GetMapping(value = "/{userHealthCounselResultSeq}")
    public ResponseEntity<UserHealthCounselResultResponse> selectUserHealthCounselResult(
        @PathVariable Long userHealthCounselResultSeq) {
        UserHealthCounselResultResponse res =
            userHealthCounselResultService.selectUserHealthCounselResult(
                userHealthCounselResultSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "사용자 보건 상담 결과 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<UserHealthCounselResultResponse>> selectUserHealthCounselResultPage(
        @ParameterObject UserHealthCounselResultRequest searchRequest, Pageable pageable) {
        Page<UserHealthCounselResultResponse> page =
            userHealthCounselResultService.selectUserHealthCounselResultPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "사용자 보건 상담 결과 삭제")
    @DeleteMapping(value = "/{userHealthCounselResultSeq}")
    public ResponseEntity<Integer> deleteUserHealthCounselResult(
        @PathVariable Long userHealthCounselResultSeq) {
        return ResponseEntity.ok(
            userHealthCounselResultService.deleteUserHealthCounselResult(userHealthCounselResultSeq));
    }
}

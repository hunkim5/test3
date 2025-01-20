package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.util.List;

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

import com.airpremia.eosh.personaldetail.basicinfo.service.BasicInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/basic-info")
@Tag(name = "기본정보")
@Slf4j
@AllArgsConstructor
public class BasicInfoController {
    private final BasicInfoService basicInfoService;

    @Operation(summary = "기본정보 페이지 조회")
    @GetMapping
    public ResponseEntity<Page<BasicInfoSearchResponse>> selectBasicInfoPage(
        @ParameterObject BasicInfoSearchRequest searchRequest, Pageable pageable) {
        Page<BasicInfoSearchResponse> result = basicInfoService.selectBasicInfoSearch(searchRequest, pageable);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "기본정보 상세 관리자")
    @GetMapping(value = "/admin/{userSeq}")
    public ResponseEntity<BasicInfoResponse> selectBasicInfo(
        @PathVariable long userSeq) {
        BasicInfoResponse res = basicInfoService.selectBasicInfo(userSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "기본정보 상세 사용자")
    @GetMapping(value = "/user")
    public ResponseEntity<BasicInfoResponse> selectBasicInfoUser() {
        BasicInfoResponse res = basicInfoService.selectBasicInfoUser();
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "사용자 자격증 리스트")
    @GetMapping(value = "/user-qualification/{userId}")
    public ResponseEntity<List<UserQualificationItemResponse>> selectUserQualificationItemByUserId(
        @PathVariable String userId) {
        return ResponseEntity.ok(basicInfoService.selectUserQualificationItemByUserId(userId));
    }

    @Operation(summary = "기본정보 수정")
    @PutMapping(value = "/{userSeq}")
    public ResponseEntity<BasicInfoResponse> updateBasicinfo(
        @PathVariable Long userSeq, @RequestBody BasicInfoUpdateRequest req) {
        req.setUserSeq(userSeq);
        BasicInfoResponse res = basicInfoService.updateBasicinfo(req);
        return ResponseEntity.ok(res);
    }
}

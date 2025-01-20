package com.airpremia.eosh.personaldetail.health.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.airpremia.eosh.personaldetail.health.service.UserNormalExamninationExcelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/user-normal-examnination/excel")
@Tag(name = "일반검진 엑셀 업로드")
@Slf4j
@AllArgsConstructor
public class UserNormalExamninationExcelController {
    private final UserNormalExamninationExcelService userNormalExamninationExcelService;

    @Operation(summary = "데이터 마이그레이션")
    @PostMapping
    public ResponseEntity<Boolean> userNormalExamninationExcel(
        @RequestParam("fileList") MultipartFile[] fileList) {
        Boolean flag = userNormalExamninationExcelService.uploadUserNormalExamninationExcelList(fileList);

        return ResponseEntity.ok(flag);
    }
}

package com.airpremia.eosh.education.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.education.service.InstructorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/instructor")
@Tag(name = "강사")
@Slf4j
@AllArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @Operation(summary = "강사 리스트 조회")
    @GetMapping
    public ResponseEntity<List<InstructorResponse>> selectEducationInstructorList() {
        return ResponseEntity.ok(instructorService.selectEducationInstructorList());
    }

    @Operation(summary = "강사 페이지 조회")
    @GetMapping(value = "/pageable")
    public ResponseEntity<Page<InstructorResponse>> selectEducationInstructorPage(
        @ParameterObject Pageable request) {
        return ResponseEntity.ok(instructorService.selectEducationInstructorPage(request));
    }

    @Operation(summary = "강사 등록")
    @PostMapping
    public ResponseEntity<Integer> insertInstructor(
        @RequestBody List<InstructorRequest> requestList) {
        return ResponseEntity.ok(instructorService.insertInstructor(requestList));
    }

    @Operation(summary = "강사 삭제")
    @DeleteMapping
    public ResponseEntity<Integer> deleteInstructor(
        @RequestBody List<InstructorDeleteRequest> deleteRequest) {
        return ResponseEntity.ok(instructorService.deleteInstructor(deleteRequest));
    }
}
